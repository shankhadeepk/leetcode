package com.hackerrankproj.hackerrank.persistent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solutions {

    public static void main(String[] args) {
       List<Long> n=new ArrayList<>();
       n.add(2l);
       n.add(4l);
       n.add(3l);

        List<Long> result=arrayChallenge(n);

        result.stream().forEach(System.out::println);
    }

    public static List<Long> arrayChallenge(List<Long> arr) {
        // Write your code here
        List<Long> result=new ArrayList<>();
        long counter=0;
        for(int i=0;i<arr.size();i++){
            counter=0;
            for(int j=i-1;j>=0;j--){
                if(arr.get(j) < arr.get(i)){
                    counter+= Math.abs(arr.get(j)-arr.get(i));
                }else {
                    counter-=Math.abs(arr.get(j)-arr.get(i));
                }
            }
            result.add(counter);
        }
        return result;

    }
}
