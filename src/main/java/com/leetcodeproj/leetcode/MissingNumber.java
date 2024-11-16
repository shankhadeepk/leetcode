package com.leetcodeproj.leetcode;

/*
*
* Leetcode 268 : Missing Number
*
*
* */
public class MissingNumber {
    /*public int missingNumber(int[] nums) {
        int t=0;
        int k=0;
        Map<Integer,Integer> integerMap=new HashMap<>();

        for (int j=0;j<nums.length;j++){
            integerMap.put(nums[j],j);
        }

        for(int i=0;i<=nums.length;i++){
            if(integerMap.get(i)==null){
                t=i;
                break;
            }
        }
        return t;
    }*/
    public int missingNumber(int[] nums){
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int [] nums={0,1};
        MissingNumber missingNumber=new MissingNumber();
        System.out.println(missingNumber.missingNumber(nums));
    }
}
