package Recursion;

public class permu_And_Comb {
    public static void main(String[] args) {
//        perm("abc","");
//        permSeats(new boolean[4],2,"");
//        combSeats(4,2,"",0);
        Q_comb_wrt_box(4,2,"",0);
//        Q_comb_2D(0,0,3,3,"",2);
    }
    public static void perm(String str,String ans)
    {
        if(str.isEmpty())
            System.out.println(ans);
        for (int i = 0; i < str.length(); i++) {
            String remaining=str.substring(0,i)+str.substring(i+1);
            perm(remaining, ans+str.charAt(i));
        }
    }
    public static void permSeats(boolean[] seats,int toSelect,String ans)
    {
        if(toSelect==0)
        {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < seats.length; i++) {
            if(!seats[i])
            {
                seats[i]=true;
                permSeats(seats, toSelect-1, ans+"b"+i);
                seats[i]=false;
            }
        }
    }
    public static void combSeats(int n,int remaining_Seats,String ans,int lastIdx)
    {
        if(remaining_Seats==0)
        {
            System.out.println(ans);
            return;
        }
        for (int i = lastIdx; i <n; i++) {
            combSeats(n, remaining_Seats-1, ans+"b"+i, i+1);
        }
    }
    public static void Q_comb_wrt_box(int n,int remaining_Seats,String ans,int curr_box)
    {
//        -ve BC
        if(curr_box>n)
            return;
//        +ve BC
        if(remaining_Seats==0)
        {
            System.out.println(ans);
            return;
        }
        //1 baar queen baithane ki call
        Q_comb_wrt_box(n, remaining_Seats-1, ans+"q"+curr_box, curr_box+1);
        //1 baar queen na baithane ki
        Q_comb_wrt_box(n, remaining_Seats, ans, curr_box+1);
    }

    public static void Q_comb_2D(int i,int j,int dest_r,int dest_c,String ans,int remaining)
    {
       if(remaining==0)
       {
           System.out.println(ans);
           return;
       }
       if(j==dest_c)
       {
           j=0;
           i++;
       }
        if(i==dest_r)
            return;

        Q_comb_2D(i, j+1, dest_r, dest_c, ans+"q{"+i+", "+j+"}", remaining-1);
        Q_comb_2D(i, j+1, dest_r, dest_c, ans, remaining);
    }


}
