package com.leetcodeproj.leetcode;

//Letter Combinations of a Phone Number

import java.util.ArrayList;
import java.util.List;

/*1    2    3
    abc   def
4     5    6
ghi  jkl  mno
7      8    9
pqrs  tuv   wxyz
*    0    #

digit 23
o/p {ad,ae,af,bd,be,bf,cd,ce,cf}
*/
public class PhoneNumber {
    public List<String> letterCombinations(String digits){
        ArrayList<String> result=new ArrayList<>();

        if(digits!=null && digits.length()>0){
            String map[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
            dfs(digits,map,result,new StringBuilder(),0);
        }
        return result;
    }

    private void dfs(String digits, String[] map, ArrayList<String> result, StringBuilder sb, int index) {

        if(index == digits.length()){
            result.add(sb.toString());
            return;
        }
        int digit=Character.getNumericValue(digits.charAt(index));
        String letters=map[digit];

        for(int i=0;i<letters.length();i++){
            char ch=letters.charAt(i);
            sb.append(ch);
            dfs(digits,map,result,sb,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        PhoneNumber phoneNumber=new PhoneNumber();
        System.out.println(phoneNumber.letterCombinations("236").size());
        phoneNumber.letterCombinations("236").stream().forEach(System.out::println);
    }
}
