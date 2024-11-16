package com.leetcodeproj.leetcode;

//Leetcode 387. First Unique Character in a String
public class FirstUniqueCharacter {
    public static void main(String[] args) {
        String s="leetcode";
        System.out.println(firstUniqChar(s));
    }
    /*public static int firstUniqChar(String s) {
        Map<Character,Integer> result=new HashMap<>();
        char[] sArr=s.toCharArray();

        for(int i=0;i<sArr.length;i++){
            if(result.get(sArr[i])==null){
                result.put(sArr[i],1);
            }else {
                result.put(sArr[i],result.get(sArr[i])+1);
            }
        }
        for(int i=0;i<sArr.length;i++){
            if(result.get(sArr[i])==1){
                return i;
            }
        }
        return -1;
    }*/
    public static int firstUniqChar(String s) {

        if(s==null || s.isEmpty())
            return -1;

        char[] sArr=new char[26];

        for(int i=0;i<s.length();i++){
           sArr[s.charAt(i) - 'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(sArr[s.charAt(i) - 'a']==1)
                return i;
        }
        return -1;
    }
}

