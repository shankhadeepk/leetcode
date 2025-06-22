package com.leetcodeproj.leetcode.stringproblems;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RemovalOfDuplicateChars {

    public static void main(String[] args) {
        String s = "HappynewYear";
        Set<Character> charList = s.chars().mapToObj(c -> (char) c).collect(Collectors.toCollection(LinkedHashSet::new));

        charList.stream().forEach(System.out::print);

    }
}
