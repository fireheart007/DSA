package Recursion;

public class rec_basic {
    public static void main(String[] args) {
//        System.out.println(pow(2,5));
//        System.out.println(fact(5));
        System.out.println(fib(6));
    }

    public static int pow(int x,int n)
    {
        if(n==0)
            return 1;
        return x*pow(x,n-1);
    }
    public static int fact(int n)
    {
        if(n==0)
            return 1;
        return n*fact(n-1);
    }
    public static int fib(int n)
    {
        if(n<=1)
            return n;
        return fib(n-1)+fib(n-2);
    }
}

