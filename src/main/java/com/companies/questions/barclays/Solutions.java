package com.companies.questions.barclays;

import java.util.Arrays;

/**
 *
 * K Step Function
 * You are given the following:
 * Integer N
 * Array A (1-based) containing N positive integers
 * Integer Q
 * Q queries, each query contains 3 integers L, R, K
 * You are given an array A (1-based) of length N, the K-step sum array B of array A is an array of length N whose i^th element can be determined as follows: B[ i ] = A[ 1 ] + F [ i ], where
 * F[i] = 0, 1 ≤ i < K and F[i] = Σ(j=K) to i      A [ K × ⌊ j / K ⌋  ] otherwise. Here ⌊x⌋
 * is the floor function which denotes the greatest integer less than or equal to x.
 *
 *
 * Assumptions:
 * N = 3
 * A = [1,2,3]
 * Q = 1
 * Queries = [[1,2,2]]
 *
 *
 * Approach
 * - You have  K = 2 , the 2-step sum array B would be: [1, 3, 5].
 * - The sum of elements of B in index range [1, 2] is 1+ 3 = 4
 * - Therefore the output is 4.
 * **/
public class Solutions {
    public static void main(String[] args) {
        Solutions s = new Solutions();
        s.kStepFunction();
    }

    void kStepFunction(){
        int n = 3;
        int[] aArr = new int[]{1,2,3};
        int[] bArr = new int[aArr.length];
        int q = 1;
        int[][] queries = new int[][]{{1,2,2}};
        int L=0, R=0, K=0;

        for(int k= 0 ; k < q ; k++){
            L = queries[k][0];
            R = queries[k][1];
            K = queries[k][2];
            System.out.println("L="+L+"R="+R+"K="+K);
            for(int i=0 ; i < n;i++){
                int f=0;
                if(i < K){
                    f=0;
                }else {
                    for (int j = 0; j < i; j++){
                        int indexVal = K * Math.floorDiv(j,K);
                        f+=aArr[indexVal];
                    }
                }
                System.out.println("F = "+f);
                bArr[i] = aArr[0] + f;
            }
        }
        Arrays.stream(bArr).forEach(System.out::println);


    }
}
