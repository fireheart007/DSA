package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Dictionary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> AL= new ArrayList<>();
        String str = sc.next();
//        dictLarge(str,"",AL,str);
        dictSmall(str,"",AL,str);
        //sorting the array list in lexographical order
        Collections.sort(AL);
        for (String s : AL) {
            System.out.println(s);
        }
    }
    public static void dictLarge(String str, String ans, ArrayList<String> AL, String temp)
    {
        if(str.isEmpty())
        {
            if(ans.compareTo(temp)>0) //Adding only those words which are lexographically greater than given string
                AL.add(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String remaining=str.substring(0,i)+str.substring(i+1);
            dictLarge(remaining, ans+str.charAt(i), AL,temp);
        }
    }
    public static void dictSmall(String str,String ans,ArrayList<String> AL,String temp)
    {
        if(str.isEmpty())
        {
            if(ans.compareTo(temp)<0)
                AL.add(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String remaining=str.substring(0,i)+str.substring(i+1);
            dictSmall(remaining,ans+str.charAt(i),AL,temp);
        }
    }
}
