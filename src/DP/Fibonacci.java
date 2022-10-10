package DP;

public class Fibonacci {
    public static void main (String[] args) {
        int n=5;
//        int[] dp=new int[n+1];
//        System.out.println(fibTD(n,dp));
//        System.out.println(fibBU(3));
        System.out.println(fibSE(3));
    }
    public static int fibTD(int n , int[] dp)
    {
        if(n<=1)
        {
            return n;
        }
        if(dp[n]!=0)
            return dp[n];
        int sp1=fibTD(n-1,dp);
        int sp2=fibTD(n-2, dp);

        dp[n]=sp1+sp2; //Memorization

        return dp[n];
    }
    public static int fibBU(int n)
    {
        int dp[]=new int[n+1];
        dp[1]=1;
        for (int i = 2; i <=n ; i++) {
            int sp1=dp[i-1];
            int sp2=dp[i-2];
            dp[i]=sp1+sp2;
        }
        return dp[n];
    }
    public static int fibSE(int num) { //space efficient O(1) space complexity
        int sp1 = 0, sp2 = 0;
        for (int n = 0; n <= num; n++) {
            if (n <= 1) {
                sp1 = n - 1;
                sp2 = n;
                continue;
            }
            int temp = sp1;
            sp1 = sp2;
            sp2 = temp + sp1;
        }
        return sp2;
    }
}
