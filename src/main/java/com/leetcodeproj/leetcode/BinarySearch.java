package com.leetcodeproj.leetcode;

// Binary Search on array
public class BinarySearch {

    public int binarySearch(int arr[],int n,int key){

        int l=0;
        int h=n;

        while(l<=h){
            int mid=(l+h)/2;
            if(arr[mid]==key)
                return mid;
            if(key < arr[mid]){
                h=mid-1;
            }else {
                l=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch=new BinarySearch();
        int arr[]={2,4,5,6,18,20,21};
        int key =7;

        System.out.println(binarySearch.binarySearch(arr,7,key));

    }
}
