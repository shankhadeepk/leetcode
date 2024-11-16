package com.leetcodeproj.leetcode;

import java.util.Arrays;

/**
 * Leetcode 567 : Permutation of String
 *
 * Sliding window approach
 */
public class PermutationInString {

    /*public boolean isPermutation(String s1, String s2) {
        char[] cs1=s1.toCharArray();
        char[] cs2=s2.toCharArray();
        int[] tmpAr=new int[26];

        int[] arr=new int[26];

        for(int i=0;i<s1.length();i++){
            arr[cs1[i] - 'a']++;
        }
        for(int i=0;i<s2.length();i++){
            for(int j=i;(j<s1.length()+i) && (j < s2.length());j++){
                tmpAr[cs2[j]-'a']++;
            }
            if(Arrays.equals(tmpAr,arr))return true;
            tmpAr=new int[26];
        }

        return false;
    }*/

    public boolean isPermutation(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] s1hash=new int[128];
        int[] s2hash=new int[128];
        int right=0, left=0;

        while(right<s1.length()){
            s1hash[s1.charAt(right) - 'a']++;
            s2hash[s2.charAt(right) - 'a']++;
            right++;
        }
        right--;
        while (right<s2.length()){
            if(Arrays.equals(s1hash,s2hash)) return true;
            right++;
            if(right!=s2.length())
                s2hash[s2.charAt(right) - 'a']++;
            s2hash[s2.charAt(left) - 'a']--;
            left++;
        }

/*
        for(int i=0;i<s1.length();i++){
            arr[cs1[i] - 'a']++;
        }
        for(int i=0;i<s2.length();i++){
            for(int j=i;(j<s1.length()+i) && (j < s2.length());j++){
                tmpAr[cs2[j]-'a']++;
            }
            if(Arrays.equals(tmpAr,arr))return true;
            tmpAr=new int[26];
        }*/

        return false;
    }
}
