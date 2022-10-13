package DP;
//https://leetcode.com/problems/longest-common-subsequence/
public class LCS {
    public static void main(String[] args) {
        String str1="abcde";
        String str2="ace";
//        System.out.println(lcs(str1,str2,0,0));
//        System.out.println(lcstd(str1,str2,0,0,new int[str1.length()][str2.length()]));
        System.out.println(lcsbu(str1,str2));
    }
    public static int lcs(String str1, String str2, int idx1,int idx2){
        if(idx1 == str1.length() || idx2 == str2.length())
            return 0;

        if(str1.charAt(idx1)==str2.charAt(idx2)){
            int sp1=lcs(str1,str2,idx1+1,idx2+1)+1; //if characters of both the strings are matched then increase the index of both to compare next char
            return sp1;
        }
        else{
            int sp1=lcs(str1,str2,idx1+1,idx2); //else increment 1st string's index and compare with the rest of the 2nd string
            int sp2=lcs(str1,str2,idx1,idx2+1); // or vice-versa
            return Math.max(sp1,sp2); //return the max length that is obtained from both the cases
        }
    }

    public static int lcstd(String str1, String str2, int idx1,int idx2,int[][] dp){
        if(idx1 == str1.length() || idx2 == str2.length())
            return 0;

        if(dp[idx1][idx2]!=0)
            return dp[idx1][idx2];

        if(str1.charAt(idx1)==str2.charAt(idx2)){
            dp[idx1][idx2]=lcstd(str1,str2,idx1+1,idx2+1,dp)+1;
        }
        else{
            int sp1=lcstd(str1,str2,idx1+1,idx2,dp);
            int sp2=lcstd(str1,str2,idx1,idx2+1,dp);
            dp[idx1][idx2]=Math.max(sp1,sp2);
        }
        return dp[idx1][idx2];
    }

    public static int lcsbu(String str1, String str2){
        int[][] dp=new int[str1.length()+1][str2.length()+1];

        for(int idx1=str1.length()-1;idx1>=0;idx1--){
            for(int idx2=str2.length()-1;idx2>=0;idx2--){

                if(str1.charAt(idx1)==str2.charAt(idx2))
                    dp[idx1][idx2]=dp[idx1+1][idx2+1]+1;

                else{
                    int sp1=dp[idx1+1][idx2];
                    int sp2=dp[idx1][idx2+1];
                    dp[idx1][idx2]=Math.max(sp1,sp2);
                }
            }
        }
        return dp[0][0];
    }
}
