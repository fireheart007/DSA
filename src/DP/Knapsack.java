package DP;
//https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
public class Knapsack {
    public static void main(String[] args) {
        int W = 4;
        int val[] = {1,2,3};
        int wt[] = {4,5,1};
//        System.out.println(knapSackTD(W,0,wt,val,new int[W+1][val.length]));
        System.out.println(knapSackBU(wt,val,W));
    }
    public static int knapSackTD(int w,int i, int wt[], int val[],int[][] dp) {
        if(i==val.length)
            return 0;
        if(dp[w][i]!=0)
            return dp[w][i];
        int sp1=0;
        if((w-wt[i])>=0)
            sp1=knapSackTD(w-wt[i],i+1,wt,val,dp)+val[i];
        int sp2=knapSackTD(w,i+1,wt,val,dp);
        dp[w][i]=Math.max(sp1,sp2);
        return dp[w][i];
    }
    public static int knapSackBU(int[] wt, int[] val,int W){
        int[][] dp= new int[W+1][val.length+1];
        for(int w=0;w<=W;w++){
            for(int i=val.length-1;i>=0;i--){
                int sp1=0;
                if((w-wt[i])>=0)
                    sp1=dp[w-wt[i]][i+1]+val[i];
                int sp2=dp[w][i+1];
                dp[w][i]=Math.max(sp1,sp2);
            }
        }
        return dp[W][0];
    }
}
