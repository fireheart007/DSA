package DP;
//Question :- https://leetcode.com/problems/distinct-subsequences/
//similar to edit distance
public class Distinct_Subseq {
    public static void main(String[] args) {
        String s="rabbbit";
        String t="rabbit";
//        System.out.println(subseqTD(s,0,t,0,new Integer[s.length()][t.length()]));
        System.out.println(subseqBU(s,t));
    }
    public static int subseqTD(String str,int idx1,String t,int idx2,Integer[][] dp)
    {
        if(idx2==t.length())
            return 1;
        if(idx1==str.length())
            return 0;
        if(dp[idx1][idx2]!=null)
            return dp[idx1][idx2];
        if(str.charAt(idx1)==t.charAt(idx2))
        {
            int sp1=subseqTD(str, idx1+1, t, idx2+1,dp); //include call
            int sp2=subseqTD(str, idx1+1, t, idx2,dp); //exclude call
            dp[idx1][idx2]=sp1+sp2;
            return sp1+sp2;
        }
        else
        {
            dp[idx1][idx2]=subseqTD(str, idx1+1, t, idx2,dp);
            return dp[idx1][idx2];
        }
    }
    public static int subseqBU(String str,String t)
    {
        int[][] dp=new int[str.length()+1][t.length()+1];
        for (int i =str.length()-1; i>=0 ; i--) {
            for (int j =t.length()-1; j >=0; j--) {
                if(str.charAt(i)==t.charAt(j))
                {
                    int sp1=1;
                    if(j<t.length()-1)
                        sp1=dp[i+1][j+1];
                    int sp2=dp[i+1][j];
                    dp[i][j]=sp1+sp2;
                }
                else
                {
                    dp[i][j]=dp[i+1][j];
                }
            }

        }
        return dp[0][0];
    }
}
