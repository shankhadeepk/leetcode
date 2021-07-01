package com.leetcodeproj.leetcode;

public class DuplicateChars {

    private static final int NO_OF_CHARS=256;

    public void printDups(String word){
        int [] allChars=new int[NO_OF_CHARS];
        calculateDups(allChars,word);

        for(int i=0;i<allChars.length;i++){
            if(allChars[i]>1) System.out.println((char)i+" "+allChars[i]);
        }
    }
    public void calculateDups(int[] allChars,String word){
        for(int i=0;i<word.length();i++){
            allChars[word.charAt(i)]++;
        }
    }

    public static void main(String[] args) {
        DuplicateChars duplicateChars=new DuplicateChars();
        duplicateChars.printDups("geeksforgeeks");

    }
}
