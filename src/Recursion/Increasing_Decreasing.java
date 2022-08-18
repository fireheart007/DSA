package Recursion;

public class Increasing_Decreasing {
    public static void main(String[] args) {
        PID(1,5);
    }
    public static void PID(int s,int n)
    {
        if(s>n)
            return;
        System.out.println(s);
        PID(s+1,n);
        System.out.println(s);
    }
}
