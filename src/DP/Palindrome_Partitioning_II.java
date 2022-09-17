package DP;
//https://leetcode.com/problems/palindrome-partitioning-ii/
public class Palindrome_Partitioning_II {
    public static void main(String[] args) {
        String str="ababab";
//        ans me se -1 krna padega kyunki function me string ke last element ke baad bhi partition ho jaata hai, for eg:- if str="abc" then c ke baad bhi ek
//        partition ko function count krega

//        System.out.println(pp(str,0)-1);
//        System.out.println(ppTD(str,0,new int[str.length()])-1);
        System.out.println(ppBU(str)-1);
    }
    public static boolean isPalin(String str,int i,int j){
        while(i<j)
        {
            if(str.charAt(i)!=str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public static int pp(String str,int idx){
        if(idx==str.length())
            return 0;
        int min_cost=Integer.MAX_VALUE;

        for(int j=idx;j<=str.length()-1;j++){
            if(isPalin(str,idx,j)){
                int cost=pp(str,j+1)+1;
                min_cost=Math.min(min_cost,cost);
            }
        }
        return min_cost;
    }

    public static int ppTD(String str,int idx,int[] dp){

        if(idx==str.length())
            return 0;
        if(dp[idx]!=0)
            return dp[idx];
        int min_cost=Integer.MAX_VALUE;

        for(int j=idx;j<=str.length()-1;j++){
            if(isPalin(str,idx,j)){
                int cost=ppTD(str,j+1,dp)+1;
                min_cost=Math.min(min_cost,cost);
            }
        }
        dp[idx]=min_cost;
        return dp[idx];
    }

    public static int ppBU(String str){
        int[] dp=new int[str.length()+1];
        for (int idx=str.length()-1; idx>=0; idx--) {
            int min_cost=Integer.MAX_VALUE;
            for(int j=idx;j<=str.length()-1;j++){
                if(isPalin(str,idx,j)){
                    int cost=dp[j+1]+1;
                    min_cost=Math.min(min_cost,cost);
                }
            }
            dp[idx]=min_cost;
        }
        return dp[0];
    }

}
