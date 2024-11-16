package com.hackerrankproj.hackerrank.bookinggo;

import java.util.Stack;

public class BalancedParanthesis {

    public boolean isParanthesisBalanced(String str) {
        if(str==null || str.isEmpty()) return false;
        Stack<Character> st=new Stack<>();
        for(int i=0;i<str.length();i++){
            switch (str.charAt(i)){
                case ')': if(!st.isEmpty() && st.peek()=='(') st.pop();
                          else return false;break;
                case '}': if(!st.isEmpty() && st.peek()=='{') st.pop();
                           else return false;break;
                case ']': if(!st.isEmpty() && st.peek()=='[') st.pop();
                          else return false;break;
                default:st.push(str.charAt(i));
            }
        }
        if(st.isEmpty()) return true;

        return false;
    }
}
