package com.simple;

public class ReverseANumber {

    public static void main(String[] args) {
        int num = 10023;
        int newNumber = 0;
        while(num >= 1) {
            int modnum = num % 10;
            num = num / 10;
            newNumber = newNumber * 10 + modnum;
        }
        System.out.println(newNumber);
    }

}
