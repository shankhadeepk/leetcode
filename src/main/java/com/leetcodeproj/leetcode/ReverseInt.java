package com.leetcodeproj.leetcode;

public class ReverseInt {
    public static void main(String[] args) {
        int a= -2345;
        System.out.println(reverse(1534236469));

        System.out.println((int)Math.pow(2,31));
    }
    public static int reverse(int x) {
        boolean isSigned = x>0?false:true;
        long tmp=0;
        x=Math.abs(x);
        while(x!=0){
            tmp=(tmp*10)+x%10;
            x=x/10;
        }
        if(isSigned)tmp=tmp*-1;
        if(tmp>Integer.MAX_VALUE || tmp<Integer.MIN_VALUE)return 0;
        return (int)tmp;
    }
}
