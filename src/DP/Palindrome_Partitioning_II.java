package DP;
//https://leetcode.com/problems/palindrome-partitioning-ii/
public class Palindrome_Partitioning_II {
    public static void main(String[] args) {
        System.out.println(pp("aab",0));
    }
    public static int pp(String str,int idx){

        if(idx==str.length()-1)
            return 0;

        int min_cost=Integer.MAX_VALUE;

        for(int j=idx;j<str.length();j++){
            if(isPalin(str,idx,j)){
                int cost=pp(str,j+1)+1;
                min_cost=Math.min(min_cost,cost);
            }
        }
        return min_cost;
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
}
