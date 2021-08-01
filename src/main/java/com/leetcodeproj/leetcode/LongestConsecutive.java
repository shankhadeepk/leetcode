package com.leetcodeproj.leetcode;

import java.util.Arrays;

/*
*
* Leetcode 128: Longest Consecutive Sequence
*
* 1. Sorted the sequence
* 2. Check after traversing each element from 1th position that its not equal to previous
* 3. If present is previous+1 then count++
* 4. else check which is max (count / max) and set count to 1
* 5. at last check which is max (count/max)
*
* */
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int count = 1;
        int max = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            //System.out.println("count ="+count);
        }
        return Math.max(max, count);
    }

    public static void main(String[] args) {
        int [] nums={9,1,4,7,3,-1,0,5,8,-1,6};
        LongestConsecutive longestConsecutive=new LongestConsecutive();
        System.out.println(longestConsecutive.longestConsecutive(nums));
    }

    private void printArr(int[] nums){
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]);
        }
        System.out.println();
    }
}
