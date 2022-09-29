package DP;

import java.util.Arrays;

//link :- https://leetcode.com/problems/minimum-path-sum/
public class Min_path_sum {
    public static void main(String[] args) {
        int[][] arr={{1,3,1},{4,2,1},{7,1,1}};
//        System.out.println(pathTD(arr,0,0,new int[arr.length][arr[0].length]));
        System.out.println(pathBU(arr));
    }
    public static int pathTD(int[][] arr, int i, int j,int[][] dp)
    {
        if(i==arr.length || j==arr[0].length)
            return Integer.MAX_VALUE;
        if(i==arr.length-1 && j==arr[0].length-1)
        {
            return arr[i][j];
        }
        if(dp[i][j]!=0)
            return dp[i][j];
        int sp1=pathTD(arr,i,j+1,dp);
        int sp2=pathTD(arr,i+1,j,dp);
        dp[i][j]=Math.min(sp1,sp2)+arr[i][j];
        return dp[i][j];
    }
    public static int pathBU(int[][] arr)
    {
        int[][] dp=new int[arr.length][arr[0].length];
        for (int i = arr.length-1; i>=0; i--) {
            for (int j =arr[0].length-1; j>=0; j--) {
                if(i==arr.length-1 && j==arr[0].length-1)
                {
                    dp[i][j]=arr[i][j];
                    continue;
                }
//        To satisfy this condition -->
//        if(i==arr.length || j==arr[0].length)
//            return Integer.MAX_VALUE;
//        We have to initialize sp1 & sp2 to Integer.MAX_VALUE if i+1==arr.length or j+1==arr[0].length so that we can calculate Math.min(sp1,sp2)
                int sp1=Integer.MAX_VALUE,sp2=Integer.MAX_VALUE;
                if(j+1<arr[0].length)
                    sp1=dp[i][j+1];
                if(i+1<arr.length)
                    sp2=dp[i+1][j];
                dp[i][j]=Math.min(sp1,sp2)+arr[i][j];
            }
        }
        return dp[0][0];
    }
}
