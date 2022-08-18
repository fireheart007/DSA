package Recursion;

import java.util.Arrays;

public class Merge_Sort {
    public static void main(String[] args) {
        int[] arr= {5,1,7,3};
        int[] sorted=sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(sorted));
    }
    //Merge function will merge 2 sorted arrays in a sorted manner
    public static int[] merge(int[] a, int[] b)
    {
        int idx1=0,idx2=0,i=0;
        int[] c = new int[a.length+b.length];
        //Dono array ko length tak compare karo or jo chhota ho us element ko nayi array me daal do
        while(idx1<a.length && idx2< b.length)
        {
            if(a[idx1]>b[idx2])
            {
                c[i]=b[idx2];
                i++;
                idx2++;
            }
            else
            {
                c[i]=a[idx1];
                i++;
                idx1++;
            }
        }
        //Ab jo bachi hui array ke element hai unhe daal do
        //Humesha koi ek hi array ke hi element bachenge kabhi bhi dono arrays ke element nhi bachenge
        //lekin hume nhi pta ki konsi array ke element bache hai isliye hum dono ke liye loop chala denge
        while(idx1< a.length)
        {
            c[i]=a[idx1];
            i++;
            idx1++;
        }
        while(idx2< b.length)
        {
            c[i]=b[idx2];
            i++;
            idx2++;
        }
        return c;
    }
    public static int[] sort(int[] arr,int s,int e)
    {
        if(s==e)
        {
            int[] ans=new int[1];
            ans[0]=arr[s];
            return ans;
        }
        int mid=(s+e)/2;
        int[] left=sort(arr, s, mid);
        int[] right=sort(arr,mid+1,e);
        return merge(left,right);
    }
}
