package com.leetcodeproj.leetcode;

public class NumberPalindrom {

    public static void main(String[] args) {
        int n=121;

        System.out.println(isPalindrome(n));
    }
    public static boolean isPalindrome(int x) {
        if(x<0)return false;
        long tmp=0;
        int tmpX=x;

        while (tmpX!=0){
            tmp=tmp*10+tmpX%10;
            tmpX=tmpX/10;
        }

        if(tmp<Integer.MIN_VALUE || tmp>Integer.MAX_VALUE) return false;
        if(x==tmp) return true;
        return false;
    }
}
