package com.leetcodeproj.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate=new ContainsDuplicate();
        System.out.println(containsDuplicate.containsDuplicate(new int[]{1,2,3}));
    }

    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> count=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(count.get(nums[i])==null){
                count.put(nums[i],1);
            }else {
                return true;
            }
        }
        return false;
    }
}
