package Recursion;

public class subsequence {
    public static void main(String[] args) {
//        subseq("abc","");
//        subseqASCII("abc","");
    }
    public static void subseq(String str, String ans)
    {
        if(str.isEmpty())
        {
            System.out.println(ans);
            return;
        }
        char ch=str.charAt(0);
        //Include
        subseq(str.substring(1),ans+ch);
        //Exclude
        subseq(str.substring(1),ans);
    }
    public static void subseqASCII(String str,String ans)
    {
        if(str.isEmpty())
        {
            System.out.println(ans);
            return;
        }
        char ch=str.charAt(0);
        subseqASCII(str.substring(1),ans+ch);
        subseqASCII(str.substring(1),ans);
        subseqASCII(str.substring(1),ans+(int)ch);
    }

}
