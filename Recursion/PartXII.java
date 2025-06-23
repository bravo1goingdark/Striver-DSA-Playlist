package Recursion;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PartXII {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(sudoku(board));
        for (char[] ch : board) {
            System.out.println(Arrays.toString(ch));
        }

    }

    public static void  solveSudoku(char[][] board){
        sudoku(board);
    }

    public static boolean sudoku(char[][] board) {

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == '.') {

                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (sudoku(board)) return true;
                            board[row][col] = '.';
                        }
                    }

                    return false;
                }
            }
        }
        return true;

    }

    private static boolean isValid(char[][] board, int row, int col, char num) {

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num || board[row][i] == num) return false;


            int sr = 3 * (row / 3) + i / 3;
            int sc = 3 * (col / 3) + i % 3;

            if (board[sr][sc] == num) return false;
        }
        return true;
    }
}
