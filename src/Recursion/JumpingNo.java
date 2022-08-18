package Recursion;
//3454 is a jumping no, single digit no. are also jumping no
//Adjacent digit should have difference of 1
//Also print it wrt most significant bit (means print it lexographically)
public class JumpingNo {
    public static void main(String[] args) {
        for (int i = 1; i <=9 ; i++) {
            jumping(i,1000);
        }
    }
    public static void jumping(int curr,int limit)
    {
        if(curr>limit)
            return;
        int digit = curr%10;
        System.out.println(curr);
        if(digit>0)
            jumping(curr*10+(digit-1),limit);
        if(digit<9)
            jumping(curr*10+(digit+1),limit);
    }
}
