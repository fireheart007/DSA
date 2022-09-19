package DP;
//https://leetcode.com/problems/coin-change/
public class coin_change {
    public static void main(String[] args) {
        int[] coins={1,2,5};
        int amount=11;
//        int ans=coinTD(amount,0,coins,new int[amount+1][coins.length+1]);
        int ans=coinBU(coins,amount);
        if(ans>=1e9)
            System.out.println(-1);
        else
            System.out.println(ans);
    }
    public static int coinTD(int n,int idx,int[] arr,int[][] dp){
        if(n==0)
            return 0;
        if(dp[n][idx]!=0)
            return dp[n][idx];
        //yaha hum int_max nhi le rhe hai kyunki sp1 and sp2 me int_max+1 krne pe overflow ho jayega
        int sp1=(int)1e9,sp2=(int)1e9;
        if(n-arr[idx]>=0)
            sp1=coinTD(n-arr[idx],idx,arr,dp)+1;
        if(idx<arr.length-1)
            sp2=coinTD(n,idx+1,arr,dp);
        dp[n][idx]=Math.min(sp1,sp2);
        return dp[n][idx];
    }

    public static int coinBU(int[] arr, int amount){
        int[][] dp=new int[amount+1][arr.length+1];
        for(int n=0;n<=amount;n++){
            for(int idx=arr.length-1;idx>=0;idx--){
                if(n==0)
                {
                    dp[n][idx]=0;
                    continue;
                }
                int sp1=(int)1e9,sp2=(int)1e9;
                if(n-arr[idx]>=0)
                    sp1=dp[n-arr[idx]][idx]+1;
                if(idx<arr.length-1)
                    sp2=dp[n][idx+1];
                dp[n][idx]=Math.min(sp1,sp2);
            }
        }
        return dp[amount][0];
    }
}
