package Recursion;

public class nQueen {
    public static void main(String[] args) {
        N_queen(0,0,4,4,4,"",new boolean[4][4]);
    }
    public static void N_queen(int i,int j,int r,int c,int remaining,String ans, boolean[][] board)
    {
        if(remaining==0)
        {
            System.out.println(ans);
            return;
        }
        //Moving to next row logic
        if(j==c)
        {
            j=0;
            i++;
        }
        //-ve BC
        if(i==r)
            return;
        if(isSafe(i,j,board))
        {
            board[i][j]=true;
            N_queen(i, j+1, r, c, remaining-1, ans+"q{"+i+","+j+"}", board);
        }
        board[i][j]=false; //Make sure to back track
        N_queen(i, j+1, r, c, remaining, ans, board);
    }

    private static boolean isSafe(int i, int j, boolean[][] board) {
        //Checking upper col till the row where queen will be added to ensure there is no other queen in that col
        for (int k = 0; k < i; k++) {
            if(board[k][j])
                return false;
        }
        //Cheking row till the column where queen will be added to ensure there is no other queen in that row
        for (int k = 0; k < j; k++) {
            if(board[i][k])
                return false;
        }
        //Checking upper left diagonal
        int r=i;
        int c=j;
        while(r>=0 && c>=0)
        {
            if(board[r][c])
                return false;
            r--;
            c--;
        }
        //Cheking upper right diagonal

        //Make sure to reinitialize the values of r and c
        r=i;
        c=j;
        while(r>=0 && c< board[0].length)
        {
            if(board[r][c])
                return false;
            r--;
            c++;
        }
        return true;
    }
}
