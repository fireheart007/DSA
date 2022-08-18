package Recursion;
public class MazePath {
    static int count=0;
    public static void main(String[] args) {
        //you can move only right and down
//        mazePathRD(0,0,2,2,"");
        //you can move right ,down AND diagnolly
        mazePathDiagnol(0,0,2,2,"");
        System.out.println("\n"+count);
    }
    public static void mazePathRD(int i,int j,int destR,int destC,String path)
    {
        if(i==destR && j==destC)
        {
            System.out.println(path);
            return;
        }
        if(i>destR||j>destC)
            return;
        mazePathRD(i, j+1, destR, destC, path+"R");
        mazePathRD(i+1, j, destR, destC, path+"D");
    }
    public static void mazePathDiagnol(int i,int j,int destR,int destC,String path)
    {
        if(i==destR && j==destC)
        {
            count++;
            System.out.print(path+" ");
            return;
        }
        if(i>destR||j>destC)
            return;
        //Here V means vertical, H -> Horizontal, D -> Diagonally
        mazePathDiagnol(i+1, j, destR, destC, path+"V");
        mazePathDiagnol(i, j+1, destR, destC, path+"H");
        mazePathDiagnol(i+1, j+1, destR, destC, path+"D");
    }
}
