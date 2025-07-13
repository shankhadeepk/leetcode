package com.simple.morganstanley;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FindSecondHighestNumber {

    public static void main(String[] args) {

        List<Integer> arr = Arrays.asList(5,3,9,1,6,9,5);

        Optional<Integer> first = arr.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();

        first.ifPresent(n -> System.out.println(n));
    }
}
