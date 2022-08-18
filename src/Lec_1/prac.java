package Lec_1;

import java.util.ArrayList;
import java.util.Scanner;

class prac{
    static int count=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr={"D","IdI","DI"};
        String str=arr[2];
        if(str.charAt(0)=='D')
            System.out.println(str.charAt(0));
    }


    public static void sum_target(int[] arr, ArrayList<Integer> AL,int idx,int target)
    {
        if(idx==arr.length)
        {
            if(check(AL,target))
                for (int i = 0; i < AL.size(); i++) {
                    System.out.print(AL.get(i)+" ");
                }
            System.out.print(" ");
            return;
        }
        AL.add(arr[idx]);
        sum_target(arr,AL, idx+1,target);
        AL.remove(AL.size()-1);
        sum_target(arr,AL,idx+1,target);
    }
    public static boolean check(ArrayList<Integer> AL,int target)
    {
        int sum=0;
        for (int i = 0; i < AL.size(); i++) {
            sum=sum+ AL.get(i);
        }
        if(sum==target)
        {
            count++;
            return true;
        }
        else
            return false;
    }
    public static void duplicate(String str,String ans)
    {
        if(str.length()==1)
        {
            System.out.println(ans+str);
            return;
        }
        char ch1=str.charAt(0);
        char ch2=str.charAt(1);
        if(ch1==ch2)
            duplicate(str.substring(1),ans+ch1+"*");
        else
            duplicate(str.substring(1),ans+ch1);
    }
}



