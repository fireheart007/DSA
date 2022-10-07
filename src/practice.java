import java.util.*;
public class practice {
    public static void main(String[] args) {
        int n=4;
        System.out.println(fib(5));
    }

    public static int fib(int num){
        int sp1=0,sp2=0;
        for (int n = 0; n <=num; n++) {
            if(n<=1) {
                sp1=n-1;
                sp2=n;
                continue;
            }
            int temp=sp1;
            sp1=sp2;
            sp2=temp+sp2;
        }
        return sp2;
    }

}
