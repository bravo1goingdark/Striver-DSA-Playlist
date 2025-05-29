import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartXIIII {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        setZeroesBetter(matrix);

        for (int[] e : matrix){
            System.out.println(Arrays.toString(e));
        }
    }


    

    public static void setZeroes(int[][] matrix) {
        // time - comp O(m * n + k * (m + n))
        // space - comp O(k)
        // k = number of zeroes
        List<int[]> track = new ArrayList<>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    track.add(new int[]{i, j});
                }
            }
        }

        for (int[] e : track) {
            int row = e[0];
            int col = e[1];
            rowZeros(matrix, row, cols);
            colZeros(matrix, col, rows);
        }
    }

    private static void rowZeros(int[][] matrix, int row, int cols) {
        for (int j = 0; j < cols; j++) {
            matrix[row][j] = 0;
        }
    }

    private static void colZeros(int[][] matrix, int col, int rows) {
        for (int i = 0; i < rows; i++) {
            matrix[i][col] = 0;
        }
    }

    public static void setZeroesBetter(int[][] matrix){
        // time comp -> O(m * n)
        // space comp -> O(m + n)
        boolean[] rows = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0){
                    rows[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rows[i] || col[j]){
                    matrix[i][j] = 0;
                }
            }
        }

    }

//    public static void setZeroesOpt(int[][] matrix){
//        // time comp -> O(m * n)
//        // space comp -> O(m + n)
//
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (matrix[i][j] == 0){
//                    rows[i] = true;
//                    col[j] = true;
//                }
//            }
//        }
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (rows[i] || col[j]){
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//
//    }

}
