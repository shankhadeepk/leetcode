package com.leetcodeproj.leetcode;

import java.util.HashMap;
import java.util.Map;
/*
 * LeetCode 1: Two Sum
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *
 * Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

 */
public class TwoSums {

    public static void main(String[] args) {
        int[] list={2,7,11,15};
        TwoSums sums=new TwoSums();

        int[] result=sums.twoSum(list,9);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> match=new HashMap<>();
        int[] result=new int[2];
        int k=0;

        for(int i=0;i<nums.length;i++){
            int diff=target-nums[i];
            if(match.keySet().contains(diff)){

                result[k]=match.get(diff);k++;
                result[k]=i;
                break;
            }else {
                match.put(nums[i],i);
            }
        }
        return result;
    }
}
