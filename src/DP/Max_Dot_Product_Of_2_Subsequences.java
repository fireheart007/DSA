package DP;
//https://leetcode.com/problems/max-dot-product-of-two-subsequences/
public class Max_Dot_Product_Of_2_Subsequences {
    public static void main(String[] args) {
        int[] a={-1,-1};
        int[] b={1,1};
//        System.out.println(maxProduct(0,0,a,b));
//        System.out.println(maxProductTD(0,0,a,b,new Integer[a.length][b.length]));
        System.out.println(maxProductBU(a,b));
    }
    public static int maxProduct(int i,int j,int[] a,int[] b){
        if(i==a.length || j==b.length){
            return -(int)1e9;
        }
        int sp1=maxProduct(i+1,j+1,a,b) + a[i]*b[j]; //include
        int sp2=maxProduct(i+1,j,a,b); //make subsequence from next element of 1st array with rest of 2nd array
        int sp3=maxProduct(i,j+1,a,b); //make subsequence from next element of 2nd array with rest of 1st array
        return Math.max(sp1,Math.max(sp2,Math.max(sp3,a[i]*b[j])));
    }
    public static int maxProductTD(int i,int j,int[] a,int[] b,Integer[][] dp){
        if(i==a.length || j==b.length){
            return -(int)1e9;
        }
        if(dp[i][j]!=null)
            return dp[i][j];
        int sp1=maxProductTD(i+1,j+1,a,b,dp) + a[i]*b[j]; //include
        int sp2=maxProductTD(i+1,j,a,b,dp); //make subsequence from next element of 1st array with rest of 2nd array
        int sp3=maxProductTD(i,j+1,a,b,dp); //make subsequence from next element of 2nd array with rest of 1st array
        dp[i][j]=Math.max(sp1,Math.max(sp2,Math.max(sp3,a[i]*b[j])));
        return dp[i][j];
    }
    public static int maxProductBU(int[] a,int[] b){
        int[][] dp=new int[a.length+1][b.length+1];
        for(int i=a.length;i>=0;i--){
            for(int j=b.length;j>=0;j--){

                if(i==a.length || j==b.length){
                    dp[i][j]= -(int)1e9;
                    continue;
                }

                int sp1=dp[i+1][j+1]+ a[i]*b[j]; //include
                int sp2=dp[i+1][j]; //make subsequence from next element of 1st array with rest of 2nd array
                int sp3=dp[i][j+1]; //make subsequence from next element of 2nd array with rest of 1st array
                dp[i][j]=Math.max(sp1,Math.max(sp2,Math.max(sp3,a[i]*b[j])));
            }
        }
        return dp[0][0];
    }
}
