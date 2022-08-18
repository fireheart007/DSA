package Recursion;
//Ques link:- https://hack.codingblocks.com/app/contests/2766/379/problem

import java.util.ArrayList;
import java.util.List;

//Output all the subsets that sum to K. The output should be printed as follows :
//        1)Sets with least no of elements should be printed first.
//        2)For equal length, elements that appear later in the original set,should be printed first.
//eg:- INPUT -    5
//                1 4 6 5 3
//                10
//OUTPUT -    6 4
//            3 6 1
//            5 4 1
public class Array_Subset {
    public static void main(String[] args) {
        int[] arr={1,4,6,5,3};
        int target=10;
        List<Integer> ans=new ArrayList<>();
        subset(arr,target,ans,0);
    }
    public static void subset(int[] arr, int target, List<Integer> ans, int idx)
    {
        if(idx== arr.length)
        {
            if(check(ans,target))
            {
                String str="";
                //Here we are converting ans to string in the reverse order so that 4,6 will become 6 4
                for (int i =ans.size()-1; i>=0 ; i--) {
                    str=str+ans.get(i)+" ";
                }
                System.out.println(str);
            }
            return;
        }
        subset(arr,target,ans,idx+1);
        ans.add(arr[idx]);
        subset(arr,target,ans,idx+1);
        ans.remove(ans.size()-1);
    }
    public static boolean check(List<Integer> ans, int target) {
        int sum=0;
        for (int i = 0; i < ans.size(); i++) {
            sum=sum+ans.get(i);
        }
        if(sum==target)
            return true;
        return false;
    }
}
