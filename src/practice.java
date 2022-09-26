import java.util.*;
public class practice {
    public static void main(String[] args) {
        int n=2000;
        if((n%4==0 && n%100!=0)||n%400==0){
            System.out.println("It is a leap year");
        }
        else
            System.out.println("not leap year");
    }

}


