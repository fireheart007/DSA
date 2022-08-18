package Recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterKeypad {
    public static void main(String[] args) {
        List<String> AL=new ArrayList<String>();
        LetterComb("234","",AL);
        System.out.println(AL);
    }
    public static String getComb(char ch)
    {
        String str = "";
        switch (ch)
        {
            case '2' : str= "abc";
            break;
            case '3' : str= "def";
            break;
            case '4' : str= "ghi";
            break;
            case '5' : str= "jkl";
            break;
            case '6' : str= "mno";
            break;
            case '7' : str= "pqrs";
            break;
            case '8' : str= "tuv";
            break;
            case '9' : str= "wxyz";
            break;
        }
        return str;
    }
    public static void LetterComb(String str, String ans, List<String> AL)
    {
        if(str.isEmpty())
        {
            if(!ans.isEmpty())
                AL.add(ans);
            return;
        }
        String opt=getComb(str.charAt(0));
        for (int i = 0; i < opt.length(); i++) {
            LetterComb(str.substring(1),ans+opt.charAt(i),AL);
        }
    }
}
