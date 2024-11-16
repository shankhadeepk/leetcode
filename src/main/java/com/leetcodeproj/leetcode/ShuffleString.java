package com.leetcodeproj.leetcode;
/*
*
* 1528: Shuffle string
*
* */
public class ShuffleString {

    public String restoreString(String s, int[] indices) {
        char [] result =new char[indices.length];

        for(int i=0;i<indices.length;i++){
            result[indices[i]] = s.charAt(i);
        }

        return String.copyValueOf(result);
    }

    public static void main(String[] args) {
        int [] dtr={4,5,6,7,0,2,1,3};
        ShuffleString shuffleString=new ShuffleString();
        System.out.println(shuffleString.restoreString("codeleet",dtr));

    }
}
