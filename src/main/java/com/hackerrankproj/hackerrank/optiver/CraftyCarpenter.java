package com.hackerrankproj.hackerrank.optiver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.*;

public class CraftyCarpenter {
    public static void main(String[] args) throws Exception{
        CraftyCarpenter craftyCarpenter=new CraftyCarpenter();
        //int[] cabCapacity={2,2,4};
        //int[] itemsWorked={1,2,3,4,5,6,2};
        int[] cabCapacity={1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        long[] itemsWorked={8,26,4,25,16,28,18,21,3,6,16,17,8,23,10,22,5,6,15,1,9,6,10,4,8,17,28,19,28,6};
      //  int[] cabCapacity={8};
       // int[] itemsWorked={1,2,3,4,5,6,7,8,9,1};
        System.out.println(craftyCarpenter.getStatus(cabCapacity.length,cabCapacity,itemsWorked));
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        String[] capacity= bufferedReader.readLine().trim().split("\\s");
        int[] cabCapacity=new int[capacity.length];
        int i=0;
        for(String s:capacity){
            cabCapacity[i]=Integer.parseInt(s);
            i++;
        }
        int itemWorkedCount = Integer.parseInt(bufferedReader.readLine().trim());
        int[] itemsWorked=new int[itemWorkedCount];

        for(int j=0;j<itemWorkedCount;j++){
            itemsWorked[j]=Integer.parseInt(bufferedReader.readLine().trim());
        }


        String res = craftyCarpenter.getStatus(cabCapacity.length,cabCapacity,itemsWorked);

        bufferedWriter.write(res);
        bufferedWriter.write("\n");

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
    }
    public String readFromInput(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
            // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

            String[] capacity = bufferedReader.readLine().trim().split("\\s");
            int[] cabCapacity = new int[capacity.length];
            int i = 0;
            for (String s : capacity) {
                cabCapacity[i] = Integer.parseInt(s);
                i++;
            }
            int itemWorkedCount = Integer.parseInt(bufferedReader.readLine().trim());
            long[] itemsWorked = new long[itemWorkedCount];

            for (int j = 0; j < itemWorkedCount; j++) {
                itemsWorked[j] = Long.parseLong(bufferedReader.readLine().trim());
            }

            String res = getStatus(cabCapacity.length, cabCapacity, itemsWorked);

            bufferedWriter.write(res);
            bufferedWriter.write("\n");

            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }catch (Exception ex){
            return "INPUT_ERROR";
        }
        return "";
    }
    /*
    * The method gets the latest status of the change done by the carpenter
    *
    * @param number of cabinets present
    * @param capacities of the cabinets
    * @param items changed by the carpenter
    *
    * @return cabinet id or status of the item changed
    *
    * */
    public String getStatus(int noCabinets,int[] cabCapacity,long[] itemsWorked){

        Map<Integer, List<Integer>> cabinetRange=new HashMap<>();// Maintains the ranges of the bucket with bucket number
        List<Long> itemsKept=new LinkedList<>();
        int k=0;
        int j=0;
        int maxRange=Integer.MIN_VALUE;

        try {
            /*
            * A map "cabinetRange" is created with
            * Key = Cabinet Number, Value= [low range of itemsKept, high range itemsKept]
            *
            * */
            for (int i = 0; i < noCabinets; i++) {
                List<Integer> range = new ArrayList<>();
                range.add(k);
                range.add((k + cabCapacity[i]) - 1);
                maxRange = (k + cabCapacity[i]) - 1;// maxrange is calculated for maxrange of bucket
                cabinetRange.put(i + 1, range);
                k = k + cabCapacity[i];
            }
            /*
            * Each element of the items number changed is added to "itemsKept" list from the 0th element of List
            * Other elements are shifted accordingly to right
            * The last change is not added
            *
            * */
            for (j = 0; j < itemsWorked.length - 1; j++) {
                if(itemsKept.contains(itemsWorked[j])){
                    int existingLoc=itemsKept.indexOf(itemsWorked[j]);
                    if(existingLoc<=maxRange){
                        shiftElements(itemsKept,existingLoc);
                    }
                }
                itemsKept.add(0, itemsWorked[j]);
            }

            /*
             * Checking the last change
             * 1. If the last changed integer exists in the "itemsKept" then the bucket number is returned
             * 2. If the last changed integer is at the location of the "itemsKept" which has exceeded the "maxrange"(Till the capacity of bucket),
             *    then the item is taken from OUTSIDE
             * 3. If the last changed integer doesnot exists in the list, then its a NEW entry
             * 4. For all exceptional cases it return INPUT_ERROR
             *
             * */
            if (itemsKept.contains(itemsWorked[j])) {
                int indexOfItem = itemsKept.indexOf(itemsWorked[j]);
                if (indexOfItem <= maxRange) {
                    return String.valueOf(getTheBucketId(cabinetRange, indexOfItem));
                } else if (indexOfItem > maxRange) {
                    return "OUTSIDE";
                }
            }
            if (!itemsKept.contains(itemsWorked[j])) {
                return "NEW";
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return "INPUT_ERROR";
        }

        return "INPUT_ERROR";
    }
    /*
    * The method returns the bucket id to which the item belongs to
    *
    * @param  the map of the cabinetRange
    * @return the bucket id
    *
    * */
    private int getTheBucketId(Map<Integer, List<Integer>> cabinetRange,int indexOfItem){

        for(Map.Entry<Integer,List<Integer>> entry:cabinetRange.entrySet()){
            if(indexOfItem >= entry.getValue().get(0) && indexOfItem <= entry.getValue().get(1)){
                return entry.getKey();
            }
        }
        return -1;
    }
    /*
    * If the item which is in the itemChange list has already occurred then need to delete the ocurrence
    *
    * @param list of items arriving
    * @param location of item already present
    *
    * */
    private void shiftElements(List<Long> itemsKept,int endloc){
        for(int i=endloc;i<itemsKept.size()-1;i++){
            itemsKept.set(i,itemsKept.get(i+1));
        }
    }
}
