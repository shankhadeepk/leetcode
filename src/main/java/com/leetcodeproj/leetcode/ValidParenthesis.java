package com.leetcodeproj.leetcode;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        ValidParenthesis validParenthesis=new ValidParenthesis();
        System.out.println(validParenthesis.isValid("{}[]()"));
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char a;
        boolean result=false;

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);

            if (x == '(' || x == '[' || x == '{') {
                stack.push(x);
                continue;
            }
            if (stack.isEmpty())
                return false;

            switch (x) {
                case ')':
                    a=stack.pop();
                    if (a == '{' || a== '[')
                        return false;
                    break;

                case '}':
                    a=stack.pop();
                    if (a == '(' || a == '[')
                        return false;
                    break;

                case ']':
                    a=stack.pop();
                    if (a == '(' || a == '{')
                        return false;
                    break;
            }
        }
        if(stack.isEmpty())return true; else return false;

    }
}
