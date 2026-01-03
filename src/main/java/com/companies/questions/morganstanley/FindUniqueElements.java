package com.companies.questions.morganstanley;

import java.util.*;
import java.util.stream.Collectors;

public class FindUniqueElements {

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
        newList.stream().forEach(n -> System.out.print(" "+n));

    }

    public static void anotherVersion(){
        List<Integer>  nums = Arrays.asList(7,4,5,7,2,3,3,8,8,9);
        Map<Integer,Integer> newRecord = new HashMap<>();

        nums.stream().forEach(n -> {
            newRecord.put(n,newRecord.getOrDefault(n,0) + 1);
        });

        List<Integer> collect = newRecord.entrySet().stream()
                .map(val -> val.getValue() > 1 ? 0 : val.getKey()).filter(v -> v !=0).collect(Collectors.toList());

        collect.stream().forEach(e -> System.out.println(" "+e));
    }
}
