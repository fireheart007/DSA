package DP;
//https://www.codechef.com/MALI2017/problems/MAXCOST
public class Wine_Selling {
    public static void main(String[] args) {
        int[] arr={2,3,5,1,4};
//        System.out.println(wine(arr,0,arr.length-1,1));
//        System.out.println(wine2(arr,0, arr.length-1));
//        System.out.println(wineTD(arr,0,arr.length-1,new int[arr.length][arr.length]));
        System.out.println(wineBU(arr));
    }

    //In this case we are taking an argument 'day' extra, so when applying Bottom Up DP we have to make a 3D dp array
    public static int wine(int[] arr,int s,int e,int day){
        if(s==e)
            return arr[s]*day;
        int sp1=wine(arr,s+1,e,day+1) + arr[s]*day;
        int sp2=wine(arr,s,e-1,day+1) + arr[e]*day;
        return Math.max(sp1,sp2);
    }

    public static int wine2(int[] arr,int s,int e){
        int total=arr.length;
        int remaining=e-s+1;
        int day=total-remaining+1; //so we will use this logic of making day to reduce 3D dp to 2D dp

        if(s==e)
            return arr[s]*day;
        int sp1=wine2(arr,s+1,e) + arr[s]*day;
        int sp2=wine2(arr,s,e-1) + arr[e]*day;
        return Math.max(sp1,sp2);
    }

    public static int wineTD(int[] arr,int s,int e,int[][] dp){
        int total=arr.length;
        int remaining=e-s+1;
        int day=total-remaining+1; //so we will use this logic of making day to reduce 3D dp to 2D dp
        if(s==e)
            return arr[s]*day;
        if(dp[s][e]!=0)
            return dp[s][e];
        int sp1=wineTD(arr,s+1,e,dp) + arr[s]*day;
        int sp2=wineTD(arr,s,e-1,dp) + arr[e]*day;
        dp[s][e]=Math.max(sp1,sp2);
        return dp[s][e];
    }

    public static int wineBU(int[] arr){
        int[][] dp=new int[arr.length][arr.length];
        for (int s =arr.length-1; s>=0 ; s--) {
            for (int e = 0; e <arr.length ; e++) {

                int total=arr.length;
                int remaining=e-s+1;
                int day=total-remaining+1; //so we will use this logic of making day to reduce 3D dp to 2D dp

                if(s==e) {
                    dp[s][e] = arr[s] * day;
                    continue;
                }
                int sp1=0,sp2=0;
                if(s+1<arr.length)
                    sp1=dp[s+1][e] + arr[s]*day;
                if(e-1>0)
                    sp2=dp[s][e-1] + arr[e]*day;
                dp[s][e]=Math.max(sp1,sp2);
            }
        }
        return dp[0][arr.length-1];
    }



}
