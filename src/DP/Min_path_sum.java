package DP;
//link :- https://leetcode.com/problems/minimum-path-sum/
public class Min_path_sum {
    public static void main(String[] args) {
        int[][] arr={{1,3,1},{4,2,1},{7,1,1}};
//        System.out.println(minPath(arr,0,0));
//        System.out.println(minPathTD(arr,0,0,new int[arr.length][arr[0].length]));
        System.out.println(minPathBU(arr));
    }
    public static int minPath(int[][] arr, int i,int j){
        if(i==arr.length-1 && j==arr[0].length-1) // agar ek hi element hai array me to bas vo return kr do
            return arr[i][j];
        if(i==arr.length || j==arr[0].length)
            return Integer.MAX_VALUE;
        int sp1=minPath(arr,i+1,j);
        int sp2=minPath(arr,i,j+1);
        return Math.min(sp1,sp2) + arr[i][j];
    }
    public static int minPathTD(int[][] arr, int i,int j, int[][] dp){
        if(i==arr.length-1 && j==arr[0].length-1)  // agar ek hi element hai array me to bas vo return kr do
            return arr[i][j];
        if(i==arr.length || j==arr[0].length)
            return Integer.MAX_VALUE;
        if(dp[i][j]!=0)
            return dp[i][j];
        int sp1=minPathTD(arr,i+1,j,dp); //down jaake min path dhoondo
        int sp2=minPathTD(arr,i,j+1,dp); //right jaake min path dhoondo
        dp[i][j]=Math.min(sp1,sp2) + arr[i][j];  //jo bhi path min. hai usme current element ki value add kr do
        return dp[i][j];
    }
    public static int minPathBU(int[][] arr){
        int[][] dp=new int[arr.length+1][arr[0].length+1]; //dp ke size me +1 kr dia hai base cases handle krne ke liye
        for(int i=arr.length;i>=0;i--){
            for(int j=arr[0].length;j>=0;j--){
                if(i==arr.length-1 && j==arr[0].length-1){
                    dp[i][j]=arr[i][j];
                    continue;
                }
                if(i==arr.length || j==arr[0].length){
                    dp[i][j]=Integer.MAX_VALUE;
                    continue;
                }
                int sp1=dp[i+1][j];
                int sp2=dp[i][j+1];
                dp[i][j]=Math.min(sp1,sp2) + arr[i][j];
            }
        }
        return dp[0][0];
    }
}
