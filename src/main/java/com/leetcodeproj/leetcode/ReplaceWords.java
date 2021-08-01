package com.leetcodeproj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode 648: Replace Words
 *
 * Solution : Trie Data structure
 */
public class ReplaceWords {

    public String replaceWords(List<String> dictionary, String sentence) {
        String[] strArr=sentence.split("\\s");
        boolean f=false;
        StringBuilder newStr=new StringBuilder();

        for(int i=0;i<strArr.length;i++){
            for(int j=1;j<=strArr[i].length();j++){
                String subStr=strArr[i].substring(0,j);
                if(dictionary.contains(subStr)){
                    newStr.append(subStr);
                    f=true;
                    break;
                }
            }
            if(!f){
                newStr.append(strArr[i]);
            }
            newStr.append(" ");
            f=false;
        }
        return newStr.toString().trim();
    }

    public static void main(String[] args) {
        List<String> dic= Arrays.asList(new String[]{"a", "aa", "aaa", "aaaa"});
        ReplaceWords words=new ReplaceWords();
        System.out.println(words.replaceWords(dic,"a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"));
    }
}
