package Recursion;

public class CoinToss {
    public static void main(String[] args) {
//        ct(3,"");
//        cthh(4,"",false);
    }
    public static void ct(int n,String ans)
    {
        if(n==0)
        {
            System.out.println(ans);
            return;
        }
        //Heads
        ct(n-1,ans+"H");
        //Tails
        ct(n-1,ans+"T");
    }
    public static void cthh(int n,String ans,boolean lasthead)
    //This function will not print the result which have 2 consecutive heads
    {
        if(n==0)
        {
            System.out.println(ans);
            return;
        }
        if(!lasthead) //this condition will run if lasthead is false
            cthh(n-1,ans+"H",true);
        cthh(n-1,ans+"T",false);
    }
}
