package com.offer.array;

/**
 * @author zlCalma
 * @date 2019/1/16 23:23.
 */
public class Fibonacci7 {

    public int Fibonacci(int n) {

        if(n<1){
            return 0;
        }
        int [] dp = new int [n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Fibonacci7 f = new Fibonacci7();
        System.out.println(f.Fibonacci(6));
    }
}
