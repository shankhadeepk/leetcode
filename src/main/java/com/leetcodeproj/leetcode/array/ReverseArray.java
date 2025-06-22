package com.leetcodeproj.leetcode.array;

import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};

        for (int i = 0, j = arr.length - 1; i < arr.length / 2; i++, j--) {
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        Arrays.stream(arr).forEach(System.out::println);
    }
}
