package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartXI {
    public static void main(String[] args) {
        for (List<String> board : solve(4)) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
    }

    public static List<List<String>> solve(int n) {
        List<List<String>> ans = new ArrayList<>();
        Character[][] board = buildBoard(n);
        boolean[] r = new boolean[board.length];
        boolean[] tlbr = new boolean[2 * n];
        boolean[] trbl = new boolean[2 * n];
        nQueenOpt(board, 0, r, tlbr, trbl, ans);
        return ans;
    }

    private static void nQueen(Character[][] board, int col, List<List<String>> ans) {
        if (col == board[0].length) {
            ans.add(boardToStringList(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (canWePlaceSafely(board, row, col)) {
                board[row][col] = 'Q';
                nQueen(board, col + 1, ans);
                board[row][col] = '.';
            }
        }
    }

    private static boolean canWePlaceSafely(Character[][] board, int row, int col) {
        int dupRow = row;
        int dupCol = col;

        // check upper-left
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        // check left
        row = dupRow;
        col = dupCol;
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        // check lower-left
        col = dupCol;
        while (row < board.length && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row++;
            col--;
        }

        return true;
    }

    private static Character[][] buildBoard(int n) {
        Character[][] board = new Character[n][n];
        for (Character[] b : board) Arrays.fill(b, '.');
        return board;
    }

    private static List<String> boardToStringList(Character[][] board) {
        List<String> res = new ArrayList<>();
        for (Character[] row : board) {
            StringBuilder sb = new StringBuilder();
            for (Character cell : row) {
                sb.append(cell);
            }
            res.add(sb.toString());
        }
        return res;
    }

    public static void nQueenOpt(Character[][] board, int col, boolean[] r, boolean[] tlbr, boolean[] trbl, List<List<String>> ans) {

        if (board.length == col) {
            ans.add(boardToStringList(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            int topLeftBR = row + col;
            int topRightBL = row - col + board.length;

            if (r[row] || tlbr[topLeftBR] || trbl[topRightBL]) continue;

            board[row][col] = 'Q';
            r[row] = true;
            tlbr[topLeftBR] = true;
            trbl[topRightBL] = true;

            nQueenOpt(board, col + 1, r, tlbr, trbl, ans);
            board[row][col] = '.';
            r[row] = false;
            tlbr[topLeftBR] = false;
            trbl[topRightBL] = false;
        }

    }
}
