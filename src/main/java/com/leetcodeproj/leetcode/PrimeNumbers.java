package com.leetcodeproj.leetcode;

/*
*
* Leetcode 204: Count primes
*
* Algo : Sieve of Erastiosthenes
* */
public class PrimeNumbers {

    public static void main(String[] args) {
        PrimeNumbers primeNumbers=new PrimeNumbers();
        long start=System.currentTimeMillis();
        System.out.println("count="+primeNumbers.countPrimes(3));
        System.out.println("Time taken:"+(System.currentTimeMillis() - start));

        long start2=System.currentTimeMillis();
        primeNumbers.sieveOfEratosthenes(3);
        System.out.println("Time taken:"+(System.currentTimeMillis() - start2));
    }

    /*public int countPrimes(int n) {
        int count=0;
        boolean primeFlag=true;
        int m=0;

        if(n==0||n==1) return 0;

        for(int i=2;i<=n;i++){
            m=(int)Math.sqrt(i);
            for(int j=2;j<=m;j++){
                if(i%j==0) {
                    primeFlag=false;break;
                }
            }
            if(primeFlag){
                //System.out.println("prime number:"+i);
                count++;
            }
            primeFlag=true;
        }
        return count;
    }*/

    public int countPrimes(int n){
        int[] processed=new int[n+1];
        int count=0;

        if(n==1||n==0)return 0;

        for(int i=0;i<=n;i++){
            processed[i]=1;
        }
        processed[0]=0;
        processed[1]=0;

        for (int i=2;i<=Math.sqrt(n);i++){
            if(processed[i]==1){
                for(int j=2;i*j<=n;j++){
                    processed[i*j]=0;
                }
            }
        }
        for(int i=2;i<=n;i++){
            if(processed[i]==1){
                System.out.println("prime="+i);
                count++;
            }
        }

        return count;
    }
    void sieveOfEratosthenes(int n)
    {
        // Create a boolean array
        // "prime[0..n]" and
        // initialize all entries
        // it as true. A value in
        // prime[i] will finally be
        // false if i is Not a
        // prime, else true.
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++)
        {
            // If prime[p] is not changed, then it is a
            // prime
            if (prime[p] == true)
            {
                // Update all multiples of p
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }

        // Print all prime numbers
        for (int i = 2; i <= n; i++)
        {
            if (prime[i] == true)
                System.out.print(i + " ");
        }
    }
}
