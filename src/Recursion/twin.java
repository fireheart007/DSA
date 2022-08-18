package Recursion;
/**Take as input str, a string. A “twin” is defined as two instances of a char separated by a char. E.g. "AxA" the A's make a “twin”. “twins” can overlap, so "AxAxA" contains 3 “twins” - 2 for A and 1 for x. Write a function which recursively counts number of “twins” in a string. Print the value returned.*/
//OUTPUT- Display the number of twins

public class twin {
    public static void main(String[] args) {
        System.out.println(twinCount("ababa",0));
    }
    public static int twinCount(String str, int count)
    {
        if(str.length()==2)
        {
            return count;
        }
        char ch1=str.charAt(0);
        char ch2=str.charAt(2);
        if(ch1==ch2)
            return twinCount(str.substring(1), count+1);
        return twinCount(str.substring(1), count);
    }
}
