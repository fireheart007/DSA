package Recursion;

import java.util.Scanner;
//INPUT Example
//5 3 0 0 7 0 0 0 0
//6 0 0 1 9 5 0 0 0
//0 9 8 0 0 0 0 6 0
//8 0 0 0 6 0 0 0 3
//4 0 0 8 0 3 0 0 1
//7 0 0 0 2 0 0 0 6
//0 6 0 0 0 0 2 8 0
//0 0 0 4 1 9 0 0 5
//0 0 0 0 8 0 0 7 9

public class Suduko_Solver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr=new int[9][9];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j]=sc.nextInt();
            }
        }
        Suduko(0,0,arr);
    }
    public static void Suduko(int r,int c,int[][] arr)
    {
       if(c==arr[0].length)
       {
           c=0;
           r++;
       }
       if(r==arr.length)
       {
           disp(arr);
           return;
       }
        if(arr[r][c]!=0)
            Suduko(r,c+1,arr);
        else
        {
            for (int i = 1; i <=9; i++) {
                if(isSafe(r,c,i,arr))
                {
                    arr[r][c]=i;
                    Suduko(r, c+1, arr);
                    //After making the call make ele again 0 when backtracking so that it can be filled again
                    //If it is not made 0 then line 28 will be executed and nothing will be filled because it is not 0
                    arr[r][c]=0;
                }
            }
        }
    }

    private static boolean isSafe(int r, int c, int i, int[][] arr) {
        //checking element in same row
        for (int j = 0; j < 9; j++) {
            if(arr[r][j]==i)
                return false;
        }
        //checking element in same col
        for (int j = 0; j < 9; j++) {
            if(arr[j][c]==i)
                return false;
        }
        //checking box
        //suppose row = 1 and col=4 --> rr=0 it means rr*3 will be 0 and cc->1 it means cc*3 will be 3
        //rr*3 and cc*3 will give the starting index of that box
        //so box starting from 0th row and 3rd col will be box 2
        int rr=r/3;
        int cc=c/3;
        for (int j = rr*3; j <rr*3+3 ; j++) {
            for (int k = cc*3; k < cc*3+3; k++) {
                if(arr[j][k]==i)
                    return false;
            }
        }
        return true;
    }
    private static void disp(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

}
