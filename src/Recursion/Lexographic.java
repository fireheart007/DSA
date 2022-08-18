package Recursion;

public class Lexographic {
    public static void main(String[] args) {
        //agar 0 se limit tak print krna hai to loop ke bina hi ho jayega
        //lekin 1 se start kroge to loop lagana padega , for more info dry run the code
//        for (int i = 1; i <= 9; i++) {
            lexo(0,100);
//        }
    }
    public static void lexo(int curr,int limit)
    {
        if(curr>limit)
            return;
        System.out.println(curr);
        int i=0;
        if(curr==0)
            i=1;
        for (; i <=9; i++) {
            lexo(curr*10+i,limit);
        }
    }
}
