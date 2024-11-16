package com.simple;

public class AddDidgits {
    public static void main(String[] args) {
        String a="4242424242426742";
        int sum=0;
        char[] s=a.toCharArray();
        for(int i=s.length-1;i>=0;i--){
            int tmp=Character.getNumericValue(s[i]);
            System.out.println(tmp);
            if(i%2==0)
                tmp=tmp*2;
            if(tmp>9){
               int tmp1=tmp%10;
               int tmp2=tmp/10;
               tmp=tmp1+tmp2;
            }
            sum=sum+tmp;
        }
        if (sum%10 == 0)
            System.out.println("Pass");
    }
}
