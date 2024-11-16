package com.leetcodeproj.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
*Leetcode  575 : Distribute candies
*
* 1. Get each type of Candy by using set
* 2. check the min of types size / candyType size/2s
*
* */
public class DistributeCandy {

    public int distributeCandies(int[] candyType) {
        Set<Integer> types=new HashSet<>();
        for(int i:candyType){
            types.add(i);
        }
        return Math.min(types.size(),candyType.length/2);
    }

    public static void main(String[] args) {
        int[] arr={6,6,6,6,6};
        DistributeCandy distributeCandy=new DistributeCandy();
        System.out.println(distributeCandy.distributeCandies(arr));

    }
}
