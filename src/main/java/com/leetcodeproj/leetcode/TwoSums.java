package com.leetcodeproj.leetcode;

import java.util.HashMap;
import java.util.Map;

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
