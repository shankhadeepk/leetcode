package com.leetcodeproj.leetcode;
/*
*
* 72 : Edit distance
*
* */
public class EditDistance {

    public int minDistance(String word1, String word2) {

        int[][] temp=new int[word2.length()+1][word1.length()+1];

        for(int j=0;j<word1.length()+1;j++){
            temp[0][j]=j;
        }
        for(int i=0;i<word2.length()+1;i++){
            temp[i][0]=i;
        }
        /*for(int i=0;i<word2.length()+1;i++){
            for(int j=0;j<word1.length()+1;j++){
                System.out.print(temp[i][j]);
            }
            System.out.println("\n");
        }*/

        for(int i=1;i<word2.length()+1;i++){
            for(int j=1;j<word1.length()+1;j++) {
                if (word1.charAt(j-1) == word2.charAt(i-1)) {
                    temp[i][j] = temp[i - 1][j - 1];
                } else {
                    temp[i][j] = Math.min(temp[i - 1][j], Math.min(temp[i - 1][j - 1], temp[i][j - 1])) + 1;
                }
            }
        }
       /* for(int i=0;i<word2.length()+1;i++){
            for(int j=0;j<word1.length()+1;j++){
                System.out.print(temp[i][j]);
            }
            System.out.println("\n");
        }*/
        //System.out.println("Result:"+temp[word2.length()][word1.length()]);
        return temp[word2.length()][word1.length()];
    }

    public static void main(String[] args) {
        EditDistance editDistance=new EditDistance();
        editDistance.minDistance("ABCD","AECDB");
    }
}
