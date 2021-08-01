package com.hackerrankproj.hackerrank;

import java.util.*;

/*
*
* Magical Tube
*
*
* */
public class MagicalTube {

    public static void main(String[] args) {
        int[][] query={{1,2},{1,4},{1,3},{1,2},{2,-1},{2,-1}};
        int Q=6;
        int [] result= elements(Q,query);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        elements(Q,query);
    }
    public static int[] elements(int Q,int[][] query){
        Stack<Integer> st=new Stack<>();
        Stack<Integer> tempStack=new Stack<>();
        Map<Integer,Integer> tmpMap=new HashMap<>();
        List<Integer> resultL=new ArrayList<>();

        for(int i=0;i<Q;i++){
            if(query[i][0] == 1){
                int tmpKey=query[i][1];
                if(tmpMap.get(tmpKey)==null){
                    tmpMap.put(tmpKey,1);
                }else {
                    int c=tmpMap.get(tmpKey);
                    c++;
                    tmpMap.put(tmpKey,c);
                }
                st.push(tmpKey);
            }else if(query[i][0] == 2){
                    List<Integer> maxVal=getKeyForMaxCount(tmpMap);
                    while (!st.isEmpty()){
                        int tmpStEle=st.pop();
                        if(maxVal.contains(tmpStEle)){
                            resultL.add(tmpStEle);
                            int val=tmpMap.get(tmpStEle);
                            val--;
                            tmpMap.put(tmpStEle,val);
                            break;
                        }else {
                            tempStack.push(tmpStEle);
                        }
                    }
                    while (!tempStack.isEmpty()){
                        int fromTmpStackELe=tempStack.pop();
                        st.push(fromTmpStackELe);
                    }
            }
        }
        int[] result=new int[resultL.size()];
        for(int i=0;i<resultL.size();i++){
            result[i]=resultL.get(i);
        }
        return result;
    }
    private static List<Integer> getKeyForMaxCount(Map<Integer,Integer> m){
        List<Integer> maxVal=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> e:m.entrySet()){
            if(e.getValue()>max){
                maxVal.clear();
                maxVal.add(e.getKey());
                max=e.getValue();
            }else if(e.getValue()==max){
                maxVal.add(e.getKey());
            }
        }
        return maxVal;
    }
}
