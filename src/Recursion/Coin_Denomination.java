package Recursion;

import java.util.Arrays;

public class Coin_Denomination {
    public static void main(String[] args) {
//        int[] arr={1,2,3};
//        coin_t1(arr,0,4,"");
//        coin_t2(arr,0,3,"");
        int[] arr= {1,2,2,2,1,3,3};
        //We have to first sort the array for type 3
        Arrays.sort(arr);
        coin_t3(arr,0,5,"",true);
    }
    public static void coin_t1(int[] arr,int idx,int target,String ans) //type 1 - Unique coins and infinite supply
    {
        if(target==0)
        {
            System.out.println(ans);
            return;
        }
        if(target<0 || idx==arr.length)
            return;
        //Here we will make the call on same index until we achieve the target or it exceeds
        coin_t1(arr,idx,target-arr[idx],ans+arr[idx]+" ");
        //After making call on the same coin until target will be achieved or exceeded then we will move to the next coin
        coin_t1(arr,idx+1,target,ans);
    }
    public static void coin_t2(int[] arr,int idx,int target,String ans) //type 2 - Unique coins and finite supply
    {
        if(target==0)
        {
            System.out.println(ans);
            return;
        }
        if(target<0 || idx==arr.length)
            return;
        coin_t2(arr,idx+1,target-arr[idx],ans+arr[idx]+" ");
        coin_t2(arr,idx+1,target,ans);
    }
    public static void coin_t3(int[] arr,int idx,int target,String ans,boolean call) //type 3 - Duplicate coins and finite supply
    {
        if(target==0)
        {
            System.out.println(ans);
            return;
        }
        if(target<0 || idx==arr.length )
            return;

        if( call || arr[idx] != arr[idx - 1])
            coin_t3(arr,idx+1,target-arr[idx],ans+arr[idx]+" ",true);

        coin_t3(arr,idx+1,target,ans,false);
    }
}
