package com.leetcodeproj.leetcode.stringproblems;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> uniqueChars= new HashSet<>();
        int maxLength = 0;
        int left = 0;
        int right = 0;

        while(right < s.length()){
            System.out.println("before Left = "+left+" Right = "+right );
            char temp = s.charAt(right);

            if(!uniqueChars.contains(temp)){
                uniqueChars.add(temp);
                System.out.println("after Left ="+left+" Right = "+right);
                maxLength = Math.max(maxLength, right - left + 1);
                System.out.println("Max length = "+ maxLength);
                right++;
            }else {
                uniqueChars.remove(s.charAt(left));
                System.out.println("Unique chars = "+uniqueChars);
                left++;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {

        LongestSubString longestSubString = new LongestSubString();
        System.out.println(longestSubString.lengthOfLongestSubstring("abcabcbb"));
    }

}
