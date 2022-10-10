package DP;
//https://leetcode.com/problems/unique-paths-ii/
public class Unique_path_II {
    public static void main(String[] args) {
        int[][] arr={{0,0,0},{0,1,0},{0,0,0}};
//        System.out.println(unique_path(arr,0,0,new boolean[arr.length][arr[0].length]));
//        System.out.println(unique_pathTD(arr,0,0,new boolean[arr.length][arr[0].length],new Integer[arr.length][arr[0].length]));
        System.out.println(unique_pathBU(arr));
    }
    public static int unique_path(int[][] arr, int i,int j,boolean[][] visited){

        if(i==arr.length || j==arr[0].length || arr[i][j]==1 || visited[i][j]) //-ve B.C pehle likhna padega
            return 0;
        //eg:- arr[][] = {{0,0},{0,1}};
        //last element 1 hai par -ve B.C baad me likhne par +ve B.C hit ho jayega or count++ ho jayega
        if(i==arr.length-1 && j==arr[0].length-1)
            return 1;
        visited[i][j]=true;
        int sp1=unique_path(arr,i,j+1,visited); //right
        int sp2=unique_path(arr,i+1,j,visited); //down
        visited[i][j]=false;
        return sp1+sp2;
    }

    public static int unique_pathTD(int[][] arr, int i,int j,boolean[][] visited,Integer[][] dp){

        if(i==arr.length || j==arr[0].length || arr[i][j]==1 || visited[i][j])
            return 0;
        if(i==arr.length-1 && j==arr[0].length-1)
            return 1;
        if(dp[i][j]!=null)
            return dp[i][j];
        visited[i][j]=true;
        int sp1=unique_pathTD(arr,i,j+1,visited,dp); //right
        int sp2=unique_pathTD(arr,i+1,j,visited,dp); //down
        visited[i][j]=false;
        dp[i][j]=sp1+sp2;
        return dp[i][j];
    }

    public static int unique_pathBU(int[][] arr){
        int[][] dp=new int[arr.length+1][arr[0].length+1];
        boolean[][] visited=new boolean[arr.length][arr[0].length];
        for(int i=arr.length;i>=0;i--){
            for(int j=arr[0].length;j>=0;j--){
                if(i==arr.length || j==arr[0].length || arr[i][j]==1 || visited[i][j]){
                    dp[i][j]=0;
                    continue;
                }
                if(i==arr.length-1 && j==arr[0].length-1){
                    dp[i][j]=1;
                    continue;
                }
                visited[i][j]=true;
                int sp1=dp[i][j+1]; //right
                int sp2=dp[i+1][j]; //down
                visited[i][j]=false;
                dp[i][j]=sp1+sp2;
            }
        }
        return dp[0][0];
    }
}
