package com.leetcodeproj.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UniqueNumber {

    public static void firstUniqueNumber(String input){
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(input);

        while (m.find()){
            String n = m.group();

        }
    }

    public static void main(String[] args) {
        firstUniqueNumber("123kklkalk678kkkl678");
    }
}
