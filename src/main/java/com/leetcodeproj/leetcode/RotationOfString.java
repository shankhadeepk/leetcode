package com.leetcodeproj.leetcode;

public class RotationOfString {
    public static void main(String[] args) {
        RotationOfString rotation=new RotationOfString();
        System.out.println(rotation.rotateString("matching","chingma"));
    }

    //Knutt-Pratt Algo
    public boolean rotateString(String s, String goal){
        StringBuilder sbuild=new StringBuilder();
        sbuild.append(s);
        sbuild.append(s);

        return (s.length()==goal.length() && sbuild.toString().contains(goal));
    }


    /*public boolean rotateString(String s, String goal) {
        StringBuilder builder=new StringBuilder();
        char[] strc=s.toCharArray();

        if("".equalsIgnoreCase(s) && "".equalsIgnoreCase(goal)) return true;

        for(int i=0;i<s.length();i++){
           char tmp=strc[0];
           for(int j=1;j<s.length();j++){
               strc[j-1]=strc[j];
           }
           strc[s.length()-1]=tmp;
           if(goal.equalsIgnoreCase(String.copyValueOf(strc))){
               return true;
           }
        }
        return false;
    }*/

    /*public boolean rotateString(String s,String goal){
        if("".equalsIgnoreCase(s) && "".equalsIgnoreCase(goal)) return true;
        for(char x : s.toCharArray()){
            String firstLetter = s.substring(0,1);
            String otherLetters = s.substring(1, s.length());
            s = otherLetters + firstLetter;
            if(s.equals(goal)){
                return true;
            }
        }
        return false;
    }*/
}
