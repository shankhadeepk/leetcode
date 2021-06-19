package com.leetcodeproj.leetcode;

import java.util.Stack;

public class InfixToPostFix {

    public static void main(String[] args) {
        InfixToPostFix infixToPostFix=new InfixToPostFix();
        infixToPostFix.infixToPostFix("a+b*c-d/e");
    }
    public void infixToPostFix(String exp){
        Stack<Character>  st=new Stack<>();
        char[] result=new char[exp.length()];
        int k=0;
        char fromSt='\0';

        for(int i=0;i<exp.length();i++){
            if(Character.isLetterOrDigit(exp.charAt(i))){ // if operand the in exp
                result[k]= exp.charAt(i);
                k++;
            }else if(isOpenBracket(exp.charAt(i))){ // if '(' push
                st.push(exp.charAt(i));
            }else if(isClosingBracket(exp.charAt(i))){  // if ')' the pop till '('
                while(!st.isEmpty() && !isOpenBracket(st.peek())){
                        result[k] = st.pop();
                        k++;
                }
                st.pop();
            }else {
                // Operators if precedence is same or greater than exp operator then pop
                while (!st.isEmpty() && checkPrecedence(st.peek(),exp.charAt(i))){
                    result[k] = st.pop();
                    k++;
                }
                st.push(exp.charAt(i));
            }

        }
        while (!st.isEmpty()){
            if(isOpenBracket(st.peek())) {
                System.out.println("Invalid Expression");
                return;
            }
            result[k]=st.pop();
            k++;
        }
        for(int i=0;i<exp.length();i++){
            System.out.print(" "+result[i]);
        }
    }

    private boolean checkPrecedence(Character peek, char charAt) {
        if(getPrecedence(charAt) <= getPrecedence(peek)) return true;
        return false;

    }
    private int getPrecedence(char operator){
        switch (operator){
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
            case '^': return 3;
        }
        return -1;
    }
    private boolean isOpenBracket(char bracket){
        if(bracket=='(') return true;
        return false;
    }
    private boolean isClosingBracket(char bracket){
        if(bracket==')') return true;
        return false;
    }
}
