package com.leetcodeproj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Shortest Distance to charcater
*
* s= "loveleetcode"
* c= "e"
*
*
*
* */
public class ShortestDistanceToChar {

    public static void main(String[] args) {
        ShortestDistanceToChar shortestDistanceToChar=new ShortestDistanceToChar();
        String s="loveleetcode";
        char c='e';
        int[] result=shortestDistanceToChar.shortestToChar(s,c);
        for (int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }

    /*public int[] shortestToChar(String s, char c) {
        int[] result=new int[s.length()];
        List<Integer> pos=new ArrayList<>();
        int k=0;
        int min=Integer.MAX_VALUE;

        for(int i=0;i<s.length();i++){
           if(s.charAt(i)==c){
               pos.add(i);
           }
        }
        for(int i=0;i<s.length();i++){
            for(int j=0;j<pos.size();j++){
                if(min>Math.abs(i- pos.get(j))){
                    min=Math.abs(i- pos.get(j));
                }
            }
            result[i]=min;
            min=Integer.MAX_VALUE;
       }
        return result;
    }*/
    public int[] shortestToChar(String s, char c) {
        int N=s.length();
        int[] result=new int[N];
        int k=0;
        int prev=Integer.MIN_VALUE/2;

        for(int i=0;i<N;i++){
            if(s.charAt(i)==c)prev=i;
            result[i]=Math.abs(i-prev);
        }
        prev=Integer.MIN_VALUE/2;
        for(int i=N-1;i>=0;i--){
            if(s.charAt(i)==c) prev = i;
            result[i] = Math.min(result[i],Math.abs(i-prev));
        }
        return result;
    }
}
