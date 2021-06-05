package com.leetcodeproj.leetcode;

public class PermutationOfString {
    public static void main(String[] args) {
        permutation("abc");
    }

    public static void permutation(String s){
        permutation(s,"");
    }
    public static void permutation(String s, String prefix){
        if(s.length()==0)
            System.out.println(prefix);
        else {
            for(int i=0;i<s.length();i++){
                String rem=s.substring(0,i)+s.substring(i+1);
                permutation(rem,prefix+s.charAt(i));
            }
        }
    }
}
