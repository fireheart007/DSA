package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    public static void main(String[] args) {
        List<List<String>> al=new ArrayList<>();
        List<String> parts=new ArrayList<>();
        partition("aab",parts,al);
        System.out.println(al);
    }
    public static void partition(String str,List<String> parts,List<List<String>> al)
    {
        if(str.isEmpty())
        {
            al.add(new ArrayList<>(parts));
        }
        for (int i = 1; i <=str.length(); i++) {
            String chopped=str.substring(0,i);
            String remaining=str.substring(i);
            if(isPalin(chopped))
            {
                parts.add(chopped);
                partition(remaining,parts,al);
                parts.remove(parts.size()-1);
            }
        }
    }

    public static boolean isPalin(String chopped) {
        int start=0;
        int end= chopped.length()-1;
        while (start<end)
        {
            if(chopped.charAt(start)!=chopped.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
