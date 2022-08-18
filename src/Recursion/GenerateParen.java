package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParen {
    public static void main(String[] args) {
        List<String> AL=new ArrayList<>();
        genParen(2,0,0,"",AL);
        System.out.println(AL);
    }
    public static void genParen(int n, int cO, int cC, String ans,List<String> AL)
    {
        //+ve BC
        if(cO==n&&cC==n)
        {
            AL.add(ans);
            return;
        }
        //-ve BC
        if(cC>cO)
            return;
        if(cO<n)
            genParen(n, cO+1, cC, ans+"(",AL);
        if(cC<n)
            genParen(n, cO, cC+1, ans+")",AL);
    }
}
