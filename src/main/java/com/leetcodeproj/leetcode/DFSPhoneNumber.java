package com.leetcodeproj.leetcode;

import java.util.*;

public class DFSPhoneNumber {
    public static void main(String[] args) {
        DFSPhoneNumber dfsPhoneNumber =new DFSPhoneNumber();

        String[] ip=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        dfsPhoneNumber.dfs(ip,"27");
    }

    public void dfs(String[] numbers,String digits){
        int[] dg=new int[digits.length()];
        Queue<String> queue = new ArrayDeque<>();
        List<String> result=new ArrayList<>();
        queue.add("");
        String s=null;
        int count=0;

        for(int i=0;i<digits.length();i++){
            dg[i]=Character.getNumericValue(digits.charAt(i));
        }

        while(!queue.isEmpty()){
            s=queue.remove();

            if(s.toString().length()==digits.length()){
                result.add(s.toString());
            }else {
                String tableVal=numbers[dg[s.toString().length()]];
                for(int i=0;i<tableVal.length();i++){
                    queue.add(s + tableVal.charAt(i));
                }
                //count++;
            }
        }

        for (int j=0;j<result.size();j++){
            System.out.println(result.get(j));
        }
    }
}
