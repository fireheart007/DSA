package DP;
//https://hack.codingblocks.com/app/contests/2766/1397/problem
import java.util.Arrays;

public class Steps_reach_1 {
    public static void main(String[] args) {
        int n=12;
//        System.out.println(step(n));
//        int[] dp=new int[n+2];
//        System.out.println(oprTD(n,dp));
        System.out.println(oprBU(12));
    }
    public static int step(int n){ //Recursive code
        if(n==1)
            return 0;
        if(n%2==0)
            return step(n/2)+1;
        else{
            int sp1=step(n+1);
            int sp2=step(n-1);
            return Math.min(sp1,sp2)+1;
        }
    }
    public static int oprTD(int n,int[] dp)
    {
        if(n==1)
            return 0;
        if(dp[n]!=0)
            return dp[n];
        if(n%2==0)
        {
            dp[n]=1+oprTD(n/2, dp);
        }
        else
        {
            int sp1=oprTD(n-1,dp);
            int sp2=oprTD(n+1,dp);
            dp[n]=Math.min(sp1,sp2)+1;
        }
        return dp[n];
    }
    public static int oprBU(int n)
    {
        int[] dp=new int[n+1];
        for (int i = 2; i <=n; i++) {
            if(i%2==0)
                dp[i]=1+dp[i/2];
            else
            {
                int sp1=dp[(i+1)/2]+1;    //yaha humne dp[i+1] nhi lia kyunki vo to is waqt 0 hoga
                int sp2=dp[i-1];
                dp[i]=Math.min(sp1,sp2)+1;
            }
        }
//        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
