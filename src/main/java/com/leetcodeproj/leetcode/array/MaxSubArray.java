package com.leetcodeproj.leetcode.array;

import java.util.Arrays;

/**
 * 53. Maximum Subarray
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 *
 * */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {

        int currSum = 0;
        int maxSum = -Integer.MAX_VALUE;

        for(int i = 0;i< nums.length;i++){
            currSum += nums[i];
            maxSum = Math.max(currSum,maxSum);

            if(currSum <= 0)
                currSum = 0;
        }

        return maxSum;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        MaxSubArray maxSubArray= new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(nums));
    }
}
