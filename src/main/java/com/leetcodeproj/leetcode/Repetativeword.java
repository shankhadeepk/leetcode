package com.leetcodeproj.leetcode;

//A word repetation is sentence

//"aaabaaaabaaabaaaabaaaabaaaabaaaaba"
// "aaaba"
public class Repetativeword {

    public static void main(String[] args) {
            String a = "trtsrdr";
            String b= a.substring(0,3);
        System.out.println(b);
        Repetativeword r=new Repetativeword();
        System.out.println(r.maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba","aaaba"));
    }
    public int maxRepeating(String sequence, String word) {
        int count =0;
        StringBuilder temp=new StringBuilder();
        temp.append(word);
        if(sequence==null || word==null || sequence.isEmpty() || word.isEmpty())return count;

        while(sequence.contains(temp)){
            count++;
            temp.append(word);
        }

        return count;
    }
}
