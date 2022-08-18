package Recursion;
//Ques link : - https://practice.geeksforgeeks.org/problems/word-break-part-23249/1
import java.util.ArrayList;

public class Word_break2 {
    public static void main(String[] args) {
        String str="catsanddog";
        ArrayList<String> dict=new ArrayList<>();
        dict.add("cats");
        dict.add("cat");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        ArrayList<ArrayList<String>> AL =new ArrayList<>();
        func(str,new ArrayList<String>(),AL,dict);
        System.out.println(AL);
    }
    public static void func(String str, ArrayList<String> l, ArrayList<ArrayList<String>> AL, ArrayList<String> dict)
    {
        if(str.isEmpty())
        {
            AL.add(new ArrayList<>(l));
            return;
        }
        for (int i = 1; i <=str.length() ; i++) {
            if(check(str.substring(0,i),dict))
            {
                l.add(str.substring(0,i));
                func(str.substring(i),l,AL,dict);
                l.remove(l.size()-1);
            }
        }
    }

    public static boolean check(String str, ArrayList<String> dict) {
        for (int i = 0; i <dict.size(); i++) {
            if(str.equals(dict.get(i)))
                return true;
        }
        return false;
    }
}
