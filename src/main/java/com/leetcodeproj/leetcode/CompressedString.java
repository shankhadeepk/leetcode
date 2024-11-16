package com.leetcodeproj.leetcode;

import java.util.HashMap;
import java.util.Map;

//aabbccc = a2b2c3
// Leet code: Cracking coding interview - pg 150
public class CompressedString {

    public static void main(String[] args) {
        //char[] a={'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        //char[] a={'a','a','b','b','c','c','c'};
        //char[] a={'a'};
        char[] a={'a','b','c'};
        CompressedString compressedString=new CompressedString();
        System.out.println(compressedString.compress(a));

        for (char x:a){
            System.out.println(x);
        }
    }

    public int compress(char[] chars) {
        if(chars.length==0) return 0;
        if(chars.length==1) return 1;

        Map<Character,Integer> result=new HashMap<>();
        StringBuilder builder=new StringBuilder();
        int size=chars.length;
        char temp =chars[0];
        builder.append(chars[0]);
        int count =1;
        for(int i=1;i<chars.length;i++){
            char temp1=chars[i];
            if(temp==temp1){
                count++;
            }else {
                builder.append(count>1?count:"");
                builder.append(chars[i]);
                temp=chars[i];
                count=1;
            }
        }
        builder.append(count>1?count:"");
        int i=0;
        for (char s:builder.toString().toCharArray()){
            chars[i]=s;
            i++;
        }
        return builder.length();
    }
}
