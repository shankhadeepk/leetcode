package com.companies.questions.morganstanley;

import java.util.*;

public class RemoveUniqueElements {

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(7,4,2,2,9,10,9,10,23,44);
        List<Integer> newList = new ArrayList<>();
        Map<Integer,Integer> count= new HashMap<>();

        nums.stream().forEach(ele -> {
            count.put(ele,count.getOrDefault(ele,0) + 1);
        });

        count.entrySet().stream().forEach((entry -> {
            if(!(entry.getValue() > 1)){
                newList.add(entry.getKey());
            }
        }));

        System.out.println("Removed duplicate list");
        newList.stream().forEach(System.out::print);

    }
}
