package com.simple.sainsbury;

public class ReverseNumber {

    public static void main(String[] args) {

        ReverseNumber r=new ReverseNumber();
        System.out.println(r.solve(345));
    }

    public int solve(int a){
        int b=0;
        int c=0;
        while(a!=0){
            b=a%10;
            a=a/10;
            c=c*10+b;
        }
        return c;
    }
}
