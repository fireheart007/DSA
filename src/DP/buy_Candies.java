package DP;
//Ques. You love to eat candies and want to buy N(1<N<109) candy bars from the local candy shop. The shop sells two types
// of candy boxes.Medium boxes contain six candy bars and large boxes contains eight. Your task is to determine the
// minimum no. of boxes you need to buy to get exactly N candy bars. If it is not possible to get exactly N candy bars,
// then return -1.
public class buy_Candies {
    public static void main(String[] args) {
        int n=14;
        int[] dp=new int[n+1];
//        int ans=candyTD(n,dp);
        int ans=candyBU(n);
        if(ans>=1e9)
            System.out.println(-1);
        else
            System.out.println(ans);
    }
    public static int candy(int n){
        if(n==0)
            return 0;
        int sp1=(int)1e9,sp2=(int)1e9;
        //yaha hum int_max nhi le rhe hai kyunki sp1 and sp2 me int_max+1 krne pe overflow ho jayega
        if(n-6>=0)
            sp1=candy(n-6)+1;
        if(n-8>=0)
            sp2=candy(n-8)+1;
        return Math.min(sp1,sp2);
    }
    public static int candyTD(int n,int[] dp){
        if(n==0)
            return 0;
        if(dp[n]!=0)
            return dp[n];
        int sp1=(int)1e9,sp2=(int)1e9;
        if(n-6>=0)
            sp1=candyTD(n-6,dp)+1;
        if(n-8>=0)
            sp2=candyTD(n-8,dp)+1;
        dp[n]=Math.min(sp1,sp2);
        return dp[n];
    }
    public static int candyBU(int num){
        int[] dp=new int[num+1];
        for (int n = 1; n <=num; n++) {
            int sp1=(int)1e9,sp2=(int)1e9;
            if(n-6>=0)
                sp1=dp[n-6]+1;
            if(n-8>=0)
                sp2=dp[n-8]+1;
            dp[n]=Math.min(sp1,sp2);
        }
        return dp[num];
    }
}
