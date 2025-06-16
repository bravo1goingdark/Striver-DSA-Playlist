package Bsearch;

import java.util.Arrays;

public class PartXXIII {
    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24}
        };
        System.out.println(Arrays.toString(search2D(mat,14)));
    }


    public static int[] search2D(int[][] mat, int target) {
        // for row and col wise sorted matrix

        int row = 0;
        int col = mat[0].length - 1;

        while (row < mat.length && col >= 0) {

            if (mat[row][col] == target) return new int[]{row, col};
            else if (mat[row][col] > target) col--;
            else row++;
        }

        return new int[]{-1, -1};
    }
}
