package Recursion;

public class Word_Search {
    public static void main(String[] args) {
        String word="ABCCED";
        char board[][]={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist(board,word));
    }
    public static boolean exist(char[][] board,String word)
    {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]==word.charAt(0) && word_search(board,word,i,j,new boolean[board.length][board[0].length]))
                {
                        return true;
                }
            }
        }
        return false;
    }
    public static boolean word_search(char[][] board, String word,int i,int j,boolean[][] arr)
    {
        if(word.isEmpty()){
            return true;
        }
        if(i<0||j<0||i==board.length||j==board[0].length||arr[i][j]||word.charAt(0)!=board[i][j])
            return false;
        arr[i][j] = true;
        boolean op1= word_search(board, word.substring(1), i - 1, j, arr);//UP
        boolean op2= word_search(board, word.substring(1), i + 1, j, arr);//DOWN
        boolean op3= word_search(board, word.substring(1), i, j - 1, arr);//LEFT
        boolean op4= word_search(board, word.substring(1), i, j + 1, arr);//RIGHT
        arr[i][j] = false;
        return op1||op2||op3||op4;
    }
}
