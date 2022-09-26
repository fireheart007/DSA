package DP;
//https://leetcode.com/problems/house-robber/

public class House_Robber {
    public static void main(String[] args) {
        int[] nums={2,7,9,3,1};
//        yaha humne Integer wrapper class use kri hai dp array ke liye kyunki arrays element ki value 0 ho skti hai as given in constraint
//        System.out.println(HouseRobTD(nums,0,new Integer[nums.length]));

        System.out.println(HouseRobBU(nums));
    }
    public static int HouseRob(int[] arr,int idx){
        if(idx>=arr.length)
            return 0;
        int sp1=HouseRob(arr,idx+2) +arr[idx]; //Chori kar
        int sp2=HouseRob(arr,idx+1); //Chori na kar or agle ghar pe jaa
        return Math.max(sp1,sp2);
    }

    public  static int HouseRobTD(int[] arr,int idx,Integer[] dp){
        if(idx>=arr.length)
            return 0;
        if(dp[idx]!=null)
            return dp[idx];
        int sp1=HouseRobTD(arr,idx+2,dp) +arr[idx]; //Chori kar
        int sp2=HouseRobTD(arr,idx+1,dp); //Chori na kar or agle ghar pe jaa
        dp[idx]=Math.max(sp1,sp2);
        return dp[idx];
    }

    public static int HouseRobBU(int[] arr){
        //size of dp array is arr.length+2 to handle base cases of idx+1 and idx+2
        int[] dp=new int[arr.length+2];
        for(int idx=arr.length-1;idx>=0;idx--){
            int sp1=dp[idx+2]+arr[idx]; //Chori kar
            int sp2=dp[idx+1]; //Chori na kar or agle ghar pe jaa
            dp[idx]=Math.max(sp1,sp2);
        }
        return dp[0];
    }
}
