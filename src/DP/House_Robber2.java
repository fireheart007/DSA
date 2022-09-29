package DP;
//https://leetcode.com/problems/house-robber-ii/
public class House_Robber2 {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        //single element array ke liye niche vaali case fail honge as ending index will become -ve , so we are putting this if condition
        if (nums.length == 1)
            System.out.println(nums[0]);

//        else {
//            int case1 = HR(nums, 0, nums.length - 2); //1st element se start krne pr 2nd last ele tak lo
//            int case2 = HR(nums, 1, nums.length - 1); //2nd element se start krne pr last ele tak le lo
//            System.out.println(Math.max(case1, case2));
//        }

//        else{
//             int case1=HRTD(nums,0,nums.length-2,new Integer[nums.length-1]);
//             int case2=HRTD(nums,1,nums.length-1,new Integer[nums.length]);
//            System.out.println(Math.max(case1,case2));
//        }

        else{
            int case1=HRBU(nums,0,nums.length-2);
            int case2=HRBU(nums,1,nums.length-1);
            System.out.println(Math.max(case1,case2));
        }
    }
    public static int HR(int[] arr,int s,int e){   //Recursive Code
        if(s>e)
            return 0;
        int sp1=HR(arr,s+2,e)+arr[s];
        int sp2=HR(arr,s+1,e);
        return Math.max(sp1,sp2);
    }
    public static int HRTD(int[] arr,int s,int e,Integer[] dp){
        if(s>e)
            return 0;
        if(dp[s]!=null)
            return dp[s];
        int sp1=HRTD(arr,s+2,e,dp)+arr[s];
        int sp2=HRTD(arr,s+1,e,dp);
        dp[s]=Math.max(sp1,sp2);
        return dp[s];
    }

    public static int HRBU(int[] arr,int s,int e){
        int[] dp=new int[e+3];
        for(int i=e;i>=s;i--){
            int sp1=dp[i+2]+arr[i];
            int sp2=dp[i+1];
            dp[i]=Math.max(sp1,sp2);
        }
        return dp[s]; //we will return the biggest problem, which will be --> starting from index s and ending at index e, So we will return dp[s] instead of dp[0]
    }
}
