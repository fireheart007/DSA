package DP;
//https://leetcode.com/problems/uncrossed-lines/
//Similar to LCS
public class Uncrossed_Lines {
    public static void main(String[] args) {
        int[] a={2,5,1,2,5};
        int[] b={10,5,2,1,5,2};
//        System.out.println(uncrossLine(a,b,0,0));
//        System.out.println(uncrossLineTD(a,b,0,0,new Integer[a.length][b.length]));
        System.out.println(uncrossLineBU(a,b));
    }
    public static int uncrossLine(int[] a,int[] b,int i,int j){
        if(i==a.length || j==b.length)
            return 0;
        int sp1=0,sp2=0;
        if(a[i]==b[j]) //if both the elements are same then draw the line
            sp1=uncrossLine(a,b,i+1,j+1)+1;
        else{ //if elements are not same then there will be 2 sub problems:-
            sp1=uncrossLine(a,b,i,j+1); // increment index of B and compare the current element of array A with rest of B
            sp2=uncrossLine(a,b,i+1,j); //or vice versa
        }
        return Math.max(sp1,sp2);
    }
    public static int uncrossLineTD(int[] a,int[] b,int i,int j,Integer[][] dp){
        if(i==a.length || j==b.length)
            return 0;
        if(dp[i][j]!=null)
            return dp[i][j];
        int sp1=0,sp2=0;
        if(a[i]==b[j])
            sp1=uncrossLineTD(a,b,i+1,j+1,dp)+1;
        else{
            sp1=uncrossLineTD(a,b,i,j+1,dp);
            sp2=uncrossLineTD(a,b,i+1,j,dp);
        }
        dp[i][j]=Math.max(sp1,sp2);
        return dp[i][j];
    }
    public static int uncrossLineBU(int[] a,int[] b){
        int[][] dp=new int[a.length+1][b.length+1];
        for(int i=a.length-1;i>=0;i--){
            for(int j=b.length-1;j>=0;j--){

                int sp1=0,sp2=0;
                if(a[i]==b[j])
                    sp1=dp[i+1][j+1]+1;
                else{
                    sp1=dp[i][j+1];
                    sp2=dp[i+1][j];
                }
                dp[i][j]=Math.max(sp1,sp2);
            }
        }
        return dp[0][0];
    }
}
