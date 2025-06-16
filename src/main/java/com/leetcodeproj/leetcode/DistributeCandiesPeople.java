package com.leetcodeproj.leetcode;

/*
*
* LeetCode 1103: distribute candies to people
*
* */
public class DistributeCandiesPeople {

    /*public int[] distributeCandies(int candies, int num_people) {
        int [] result = new int[num_people];
        int count=1;
        int i=0;

        while(count<=candies){
            result[i]=result[i]+count;
            candies=candies-count;
            System.out.println("i="+i+" count="+count+" candies="+candies+" result="+result[i]);
            i++;
            count++;
            if(i>=num_people)i=0;
        }
        if(candies>0) {
            if (i >= num_people) {
                i = 0;
            }
            result[i]=result[i]+candies;
        }
        return result;
    }*/

    public static void main(String[] args) {
        DistributeCandiesPeople distributeCandiesPeople=new DistributeCandiesPeople();
        int[] result=distributeCandiesPeople.distributeCandies(10,3);

        for (int i=0;i<result.length;i++){
            System.out.print(" "+result[i]);
        }
    }

    public int[] distributeCandies(int candies, int num_people){
        int[] result = new int[num_people];
        int count = candies;
        for(int i=1,j=0;i<=candies;i++,j++){
            if (j == num_people){
                j=0;
            }
            if(i > count){
                result[j]=result[j] + count;break;
            }else {
                result[j]=result[j]+i;
                count=count-i;
            }
        }
        return result;
    }
}
