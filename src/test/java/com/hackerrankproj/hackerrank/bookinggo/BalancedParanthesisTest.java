package com.hackerrankproj.hackerrank.bookinggo;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BalancedParanthesisTest {

    @Test
    public void checkBalancedParenthesis_WhenStrBalanced(){
        String str="{}[]()";
        BalancedParanthesis balancedParanthesis=new BalancedParanthesis();
        assertTrue(balancedParanthesis.isParanthesisBalanced(str));
    }

    @Test
    public void checkBalancedParenthesis_WhenStrNotBalanced(){
        String str="{}[";
        BalancedParanthesis balancedParanthesis=new BalancedParanthesis();
        assertFalse(balancedParanthesis.isParanthesisBalanced(str));
    }

    @Test
    public void checkBalancedParenthesis_WhenStrNull(){
        String str=null;
        BalancedParanthesis balancedParanthesis=new BalancedParanthesis();
        assertFalse(balancedParanthesis.isParanthesisBalanced(str));
    }

    @Test
    public void checkBalancedParenthesis_WhenStrEmpty(){
        String str="";
        BalancedParanthesis balancedParanthesis=new BalancedParanthesis();
        assertFalse(balancedParanthesis.isParanthesisBalanced(str));
    }
}