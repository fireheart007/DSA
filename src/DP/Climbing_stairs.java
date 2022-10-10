package DP;
//https://leetcode.com/problems/climbing-stairs/
public class Climbing_stairs {
    public static void main(String[] args) {
        int n=5;
//        System.out.println(stairsTD(n,new int[n+1]));
//        System.out.println(stairsBU(n));
        System.out.println(stairsBUSE(n));
    }
    public static int stairsTD(int n, int[] dp)
    {
        if(n==0)
            return 1;
        if(n<0)
            return 0;
        if(dp[n]!=0)
            return dp[n];
        int sp1=stairsTD(n-1, dp);
        int sp2=stairsTD(n-2, dp);
        dp[n]=sp1+sp2;
        return dp[n];
    }
    public static int stairsBU(int n)
    {
        int[] dp=new int[n+1];
        dp[0]=1;dp[1]=1;
        for (int i = 2; i <=n ; i++) {
            int sp1=dp[i-1];
            int sp2=dp[i-2];
            dp[i]=sp1+sp2;
        }
        return dp[n];
    }
    public static int stairsBUSE(int n)  //Space efficient approach
    {
        //Climbing stairs dp array is like fibonacci, so we only have to store previous
        // two values to get the next value
        int sp1=1;
        int sp2=1;
        for (int i = 2; i <=n ; i++) {
            int temp=sp1;
            sp1=sp2;
            sp2=sp2+temp;
        }
        return sp2;
    }
}
