package Recursion;

public class English_Ruler {
    public static void main(String[] args) {
        Eng_Ruler(3,5);
    }
    public static void Eng_Ruler(int mjr_tick,int len)
    {
        for (int i = 0; i <len; i++) {
            for (int j = 0; j <mjr_tick ; j++) {
                System.out.print("-");
            }
            System.out.println(i);
            pat(mjr_tick-1);
        }
        for (int j = 0; j <mjr_tick ; j++) {
            System.out.print("-");
        }
        System.out.println(len);
    }
    public static void pat(int n)
    {
        if(n==0)
            return;
        pat(n-1);
        for (int i = 1; i <=n ; i++) {
            System.out.print("-");
        }
        System.out.println();
        pat(n-1);
    }
}
