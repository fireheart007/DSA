package Recursion;
//Here 1 means that path is blocked
//We can move Up, down, left and right
public class Blocked_Path {
    public static void main(String[] args) {
        int[][] arr=    {{0,0,1,0},
                         {0,0,0,1},
                         {1,0,0,0}};
        blockPath(arr,new boolean[arr.length][arr[0].length],0,0,"");
    }
    public static void blockPath(int[][] arr,boolean[][] Isvisited,int i,int j,String ans)
    {
        //-ve BC
        if(i<0||j<0||i== arr.length||j==arr[0].length||arr[i][j]==1||Isvisited[i][j])
            return;
        //+ve BC
        if(i== arr.length-1 && j==arr[0].length-1)
        {
            System.out.println(ans);
            return;
        }
        //Here we have taken a boolean array which will record the paths that are visited so that it cannot be visited again
        Isvisited[i][j]=true;
        blockPath(arr, Isvisited, i-1, j, ans+"U");
        blockPath(arr, Isvisited, i+1, j, ans+"D");
        blockPath(arr, Isvisited, i, j-1, ans+"L");
        blockPath(arr, Isvisited, i, j+1, ans+"R");
        Isvisited[i][j]=false;
    }
}
