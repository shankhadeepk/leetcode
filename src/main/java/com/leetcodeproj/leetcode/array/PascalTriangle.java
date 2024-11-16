package com.leetcodeproj.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        int n=5;
        PascalTriangle p= new PascalTriangle();
        List<List<Integer>> result=p.generate(n);
        for (int i=0;i<n;i++){
            for(int j=0;j<i+1;j++){
                System.out.print(result.get(i).get(j)+" ");
            }
            System.out.println();
        }

    }

    public List<List<Integer>> generate(int numRows) {
        List<Integer> row=null;
        List<List<Integer>> pascalTri=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            row=new ArrayList<>();
            for(int j=0;j<i+1;j++){
                if(i==j) row.add(1);
                else
                if(j==0) row.add(1);
                else {
                    int e=pascalTri.get(i-1).get(j-1) + pascalTri.get(i-1).get(j);
                    row.add(e);
                }
            }
            pascalTri.add(row);
        }
        return pascalTri;
    }
}
