package DP;
//https://leetcode.com/problems/edit-distance/
public class edit_distance {
    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
//        System.out.println(minDistance1(word1,word2));
//        System.out.println(minDistance2(word1,word2,0,0));
//        System.out.println(minDistance2TD(word1,word2,0,0,new Integer[word1.length()][word2.length()]));
        System.out.println(minDistance2BU(word1,word2));
    }
    public static int minDistance1(String word1, String word2) {
        if(word1.isEmpty() && word2.isEmpty())
            return 0;
        if(word1.isEmpty())
            return word2.length();
        if(word2.isEmpty())
            return word1.length();
        if(word1.charAt(0)==word2.charAt(0))
        {
            return minDistance1(word1.substring(1),word2.substring(1));
        }
        else
        {
            //Insertion
            int spI=minDistance1(word1,word2.substring(1));
            //Deletion
            int spD=minDistance1(word1.substring(1),word2);
            //Replace
            int spR=minDistance1(word1.substring(1),word2.substring(1));
            return Math.min(spI,Math.min(spD,spR))+1;
        }
    }
    //Since we are converting the original string so we can't map these values in 2D array,so either store these value in
    //hashmap or divide the string virtually using idx so that we can store values corresponding to index in 2D dp array

    public static int minDistance2(String word1, String word2,int idx1,int idx2) {
        if(idx1==word1.length() && idx2==word2.length())
            return 0;
        if(idx1==word1.length())
            return word2.length()-idx2;
        if(idx2==word2.length())
            return word1.length()-idx1;
        if(word1.charAt(idx1)==word2.charAt(idx2))
        {
            return minDistance2(word1,word2,idx1+1,idx2+1);
        }
        else
        {
            //Insertion
            int spI=minDistance2(word1,word2,idx1,idx2+1);
            //Deletion
            int spD=minDistance2(word1,word2,idx1+1,idx2);
            //Replace
            int spR=minDistance2(word1,word2,idx1+1,idx2+1);
            return Math.min(spI,Math.min(spD,spR))+1;
        }
    }

    public static int minDistance2TD(String word1, String word2,int idx1,int idx2,Integer[][] dp) {
        if(idx1==word1.length() && idx2==word2.length())
            return 0;
        if(idx1==word1.length())
            return word2.length()-idx2;
        if(idx2==word2.length())
            return word1.length()-idx1;
        if(dp[idx1][idx2]!=null)
            return dp[idx1][idx2];
        if(word1.charAt(idx1)==word2.charAt(idx2))
        {
            dp[idx1][idx2]=minDistance2TD(word1,word2,idx1+1,idx2+1,dp);
            return dp[idx1][idx2];
        }
        else
        {
            //Insertion
            int spI=minDistance2TD(word1,word2,idx1,idx2+1,dp);
            //Deletion
            int spD=minDistance2TD(word1,word2,idx1+1,idx2,dp);
            //Replace
            int spR=minDistance2TD(word1,word2,idx1+1,idx2+1,dp);
            dp[idx1][idx2]=Math.min(spI,Math.min(spD,spR))+1;
            return dp[idx1][idx2];
        }
    }

    public static int minDistance2BU(String word1, String word2) {
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        for (int i =word1.length(); i >=0 ; i--) {
            for (int j = word2.length(); j >=0 ; j--) {
                if(i==word1.length())
                {
                    dp[i][j]=word2.length()-j;
                    continue;
                }
                if(j==word2.length())
                {
                    dp[i][j]=word1.length()-i;
                    continue;
                }
                if(word1.charAt(i)==word2.charAt(j))
                {
                    dp[i][j]=dp[i+1][j+1];
                }
                else
                {
                    //Insertion
                    int spI=dp[i][j+1];
                    //Deletion
                    int spD=dp[i+1][j];
                    //Replace
                    int spR=dp[i+1][j+1];
                    dp[i][j]=Math.min(spI,Math.min(spD,spR))+1;
                }
            }
        }
        return dp[0][0];
    }
}
