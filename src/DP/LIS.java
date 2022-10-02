package DP;
//https://leetcode.com/problems/longest-increasing-subsequence/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LIS {
    public static void main(String[] args) {
        int[] arr={4,10,4,3,8,9};
//        System.out.println(LIS(arr,0,-1));

//        here size of column in dp array is arr.length+1 because prev_idx will go from -1 to arr.length-1
//        System.out.println(LISTD(arr,0,-1,new int[arr.length][arr.length+1])); //the prev_idx for the first element will be -1

//        System.out.println(LISBU(arr));
//        System.out.println(LIS_nlogn(arr));
        System.out.println(LIS_nlogn2(arr));

    }

//    O(n^2) Complexity of all the methods below till Bottom Up
    public static int LIS(int[] arr,int idx,int prev_idx){
        if(idx== arr.length)
            return 0;
        int sp1=0;
//        prev_idx==-1 --> this condition is used for making include call for the first element when prev_idx will equal to -1
        if(prev_idx==-1||arr[prev_idx]<arr[idx]) //For making LIS ,include call should only be made if the next element is greater than previous element
            sp1=LIS(arr, idx+1,idx)+1; //include the current element and move to next
        int sp2=LIS(arr,idx+1,prev_idx); //don't include
        return Math.max(sp1,sp2);
    }
    public static int LISTD(int[] arr,int idx,int prev_idx,int[][] dp){
        if(idx== arr.length)
            return 0;
        if(dp[idx][prev_idx+1]!=0)  //here we are doing [prev_idx+1] because for the biggest problem the prev_idx will be -1 and then the array will be out of bound
            return dp[idx][prev_idx+1];
        int sp1=0;
//        prev_idx==-1 --> this condition is used for making include call for the first element when prev_idx will equal to -1
        if(prev_idx==-1||arr[prev_idx]<arr[idx]) //For making LIS, include call should only be made if the next element is greater than previous element
            sp1=LISTD(arr, idx+1,idx,dp)+1; //include the current element and move to next
        int sp2=LISTD(arr,idx+1,prev_idx,dp); //don't include

//        here we are doing [prev_idx+1] because for the biggest problem the prev_idx will be -1 and then the array will be out of bound
        dp[idx][prev_idx+1]=Math.max(sp1,sp2);
        return dp[idx][prev_idx+1];
    }

    public static int LISBU(int[] arr){
        int[][] dp=new int[arr.length+1][arr.length+1]; //here the size of row is increased to arr.length+1 to handle the base case--> if(idx==arr.length)return 0;
        for (int idx =arr.length-1; idx>=0 ; idx--) {
            for (int prev_idx = arr.length-1; prev_idx>=-1 ; prev_idx--) {
                int sp1=0;
//                prev_idx==-1 --> this condition is used for making include call for the first element when prev_idx will equal to -1
                if(prev_idx==-1||arr[prev_idx]<arr[idx])
                    sp1=dp[idx+1][idx+1]+1; //here we have done [idx+1] in the column also for mapping the index as same as this --> [prev_idx+1] in TD approach
                int sp2=dp[idx+1][prev_idx+1]; //here we also have to do [prev_idx+1] in the column for the same reason as above
                dp[idx][prev_idx+1]=Math.max(sp1,sp2);
            }
        }
        return dp[0][0];
    }

//    nlogn time complexity solution
    public static int LIS_nlogn(int[] arr){
        List<Integer> AL = new ArrayList<>();
        AL.add(arr[0]); //first element of array is added directly into AL to compare with the rest of the elements of the array
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>AL.get(AL.size()-1)) //agar array ka element list me pade last element se bada hai to use list ke end me add kr do
                AL.add(arr[i]);
            else {
                int s=0,e=AL.size()-1;
                int idx=0; //declared a var to store the index of just bada element than arr[i] in the list
                while (s<=e){  //Applying binary search in AL to find just bada element than arr[i]
                    int mid=(s+e)/2;
                    if(arr[i]<=AL.get(mid)) {
                        e = mid - 1;
                        idx=mid;
                    }
                    else
                        s= mid+1;
                }
                AL.set(idx,arr[i]);  //we are inserting the element arr[i] in AL at the index where just bada element was present
            }
        }
        return AL.size();
    }

    // the binary search applied above can be implemented using "Collections.binarySearch" function, so below is the alternative code of the above code
    public static int LIS_nlogn2(int[] arr){
        List<Integer> AL = new ArrayList<>();
        AL.add(arr[0]); //first element of array is added directly into AL to compare with the rest of the elements of the array
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>AL.get(AL.size()-1)) //agar array ka element list me pade last element se bada hai to use list ke end me add kr do
                AL.add(arr[i]);
            else {
//                This function returns an index of the element, if it is contained in the AL; otherwise, (-(insertion point) – 1).
//                The insertion point is defined as the idx of just bada element.
                int idx = Collections.binarySearch(AL,arr[i]);
                if(idx<0)
                    idx=Math.abs(idx+1); //if element is not present in AL then we have to do this to make idx +ve
                AL.set(idx,arr[i]);  //we are inserting the element arr[i] in AL at the index where just bada element was present
            }
        }
        return AL.size();
    }
}
