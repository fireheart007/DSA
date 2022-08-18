package Recursion;

public class climbingStairs {
    static int count=0;
    public static void main(String[] args) {
//        climbStairs(4);
//        System.out.println(count);
        comb_Stairs(4,0,"",0);
    }
    public static void climbStairs(int n)
    {
        //+ve base case
        if(n==0)
        {
            count++;
            return;
        }
        //-ve base case
        if(n<0)
            return;
        climbStairs(n-1);
        climbStairs(n-2);
    }
    public static void comb_Stairs(int n,int curr,String ans, int lastidx)
    {
        //here order does not matter --> it means only print unique paths
        if(curr==n)
        {
            System.out.println(ans);
            return;
        }
        if(curr>n)
            return;
        if(lastidx!=2) //1 par 1 and 2 dono ki call lagaao par jab 2 par ho to 1 ki call nhi lagaani
            comb_Stairs(n, curr+1, ans+"1",1);
        comb_Stairs(n, curr+2, ans+"2",2);
    }
}
