package com.leetcodeproj.leetcode;

public class Simple {

    public static void main(String[] args) {
        Hack2 hack2=new Hack2();
        System.out.println(hack2.hackM(0));
    }
}

class Hack1{

    public int kack2(int n){
        System.out.println(n);
        return hackM(n++);
    }

    private int hackM(int n){
        return n++;
    }
}
class Hack2 extends Hack1{
    int hackM(int m){
        return kack2(++m);
    }
}
