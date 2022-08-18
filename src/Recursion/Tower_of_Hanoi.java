package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Tower_of_Hanoi {
    static List<Integer> A=new ArrayList<>();
    static List<Integer> B=new ArrayList<>();
    static List<Integer> C=new ArrayList<>();
    public static void main(String[] args) {
        A.add(3);
        A.add(2);
        A.add(1);
        TOH(3,A,C,B);
    }
    public static void TOH(int n,List<Integer> src,List<Integer> dest,List<Integer> helper)
    {
        if(n==0)
            return;
        TOH(n-1, src, helper, dest);
        dest.add(src.remove(src.size()-1));
        System.out.println(A+"\t"+B+"\t"+C);
        TOH(n-1, helper, dest, src);
    }
}
