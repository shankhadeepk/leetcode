package com.leetcodeproj.leetcode;

/**
 * Longest Palindromic Sequence
 *
 *
 */
public class LongestPalindrom {

    public static void main(String[] args) {
        System.out.println(checkLongestPlaindrom("aaamadamyyy"));
    }

    public static int checkLongestPlaindrom(String s){
        int[][] lps=new int[s.length()][s.length()];
        int max=Integer.MIN_VALUE;
        int tempLow=-1,tempHigh=-1;
        int c=0;
        int count=0;
        int high=-1,low=-1;

        for(int i=0;i<s.length();i++)
            lps[i][i]=1;

        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                lps[i][i+1]=1;
            }
        }
        // checkPalindrom
        for(int k=2;k<s.length();k++){
            for(int i=0;i<s.length()-k;i++){
                c=k+i;
                //System.out.println("i="+i+",c="+c);
                if(s.charAt(i)==s.charAt(c) && lps[i+1][c-1]==1){
                    lps[i][c]=1;
                    count=c-i+1;
                    tempLow=i;tempHigh=c;
                }
            }
            if(max<count){
                low=tempLow;
                high=tempHigh;
                max=count;
            }
        }

       /* for(int i=0;i<str.length();i++){
            for(int j=0;j<str.length();j++){
                System.out.print(lps[i][j]);
            }
            System.out.println();
        }*/

       /*if(low!=-1 && high!=-1)
        for(int k=low;k<=high;k++){
            System.out.print(str.charAt(k));
        }*/

        return max;
    }
}
