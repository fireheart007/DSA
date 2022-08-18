package Recursion;

import java.util.Arrays;

public class Array_rec {
    public static void main(String[] args) {
       int[] arr={20,40,4,25,4,5,4};
//       rev(arr,0);
//        System.out.println(max(arr,0));
//        System.out.println(first_occur(arr,4,0));
//        System.out.println(last_occur(arr,4,0));
//        System.out.println(Arrays.toString(All_Occur(arr,4,0,0)));
    }

    public static int[] All_Occur(int[] arr, int ele, int idx, int count) {
        if(idx== arr.length)
            return new int[count];
        int[] ans;
        if(arr[idx]==ele)
        {
            ans = All_Occur(arr, ele, idx + 1, count + 1);
            ans[count]=idx;
        }
        else
        {
            ans = All_Occur(arr, ele, idx + 1, count);
        }
        return ans;
    }

    public static int last_occur(int[] arr, int ele, int idx) {
        if(idx==arr.length)
            return -1;
        int sp=last_occur(arr,ele,idx+1);
        if(arr[idx]==ele && sp==-1)
            return idx;
        return sp;
    }

    public static int first_occur(int[] arr, int ele, int idx) {
        if(idx==arr.length)
            return -1;
        if(arr[idx]==ele)
            return idx;
        int sp=first_occur(arr,ele,idx+1);
        return sp;
    }

    public static int max(int[] arr, int idx) {
        if(idx== arr.length)
            return Integer.MIN_VALUE;
        int sp=max(arr,idx+1);
        return Math.max(sp,arr[idx]);
    }

    public static void rev(int[] arr, int idx)
    {
        if(idx== arr.length)
            return;
        rev(arr,idx+1);
        System.out.println(arr[idx]);
    }

}
