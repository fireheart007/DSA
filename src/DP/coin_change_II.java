package DP;
//https://leetcode.com/problems/coin-change-ii/
public class coin_change_II {
    public static void main(String[] args) {
        int n=4;
        int[] arr={1,2,5};
//        System.out.println(coin_denoTD(n,arr,0,new Integer[n+1][arr.length+1]));
//        System.out.println(coin_denoBU(n,arr));
        System.out.println(coin_denoBUSE(n,arr));
    }
    public static int coin_denoTD(int n, int[] arr,int idx,Integer[][] dp)
    {
        if(n==0)
        {
            return 1;
        }
        if(n<0 || idx== arr.length)
            return 0;
        if(dp[n][idx]!=null) //when 0 is a valid solution dp[n][idx]!=0 fails so to fix this we have to take "Integer" type array whose default value is null
            //for example if arr={2,4,6} and n=9 then we can't make 9 from them so 0 is a valid solution for amount 9,so we also have to record those values
            return dp[n][idx];
        dp[n][idx]=coin_denoTD(n-arr[idx],arr,idx,dp)+coin_denoTD(n,arr,idx+1,dp);
        return dp[n][idx];
    }
    public static int coin_denoBU(int n, int[] arr)
    {
        int[][] dp=new int[n+1][arr.length+1];
//           we have done arr.length+1 to handle the cases of
//           if(idx== arr.length) {return 0;}
        for (int i = 0; i <=n ; i++) {
            for (int j = arr.length-1; j>=0; j--) {
                //here dp[amount][0] means we have to consider all the coins from 0 to arr.length, so it is the biggest problem
                // and dp[amount][arr.length-1] means we have to consider only 1 coin, so it is the smallest problem
                if(i==0)
                {
                    dp[i][j]=1;
                    continue;
                }
                int sp1=0;
                if(i-arr[j]>=0)
                    sp1=dp[i-arr[j]][j];
                int sp2=dp[i][j+1];
                dp[i][j]=sp1+sp2;
            }
        }
        return dp[n][0];
    }

    public static int coin_denoBUSE(int n, int[] arr)
    {
        int[] right_idx=new int[n+1];
        int[] curr_idx=new int[n+1];
        for (int j = arr.length-1; j>=0; j--) {
        for (int i = 0; i <=n ; i++){
                if(i==0)
                {
                    curr_idx[i]=1;
                    continue;
                }
                int sp1=0;
                if(i-arr[j]>=0)
                    sp1=curr_idx[i-arr[j]];
                int sp2=right_idx[i];
                curr_idx[i]=sp1+sp2;
            }
            right_idx=curr_idx;
        }
        return curr_idx[n];
    }
}
