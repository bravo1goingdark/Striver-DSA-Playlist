import java.util.Arrays;

public class PartXV {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);

        for (int[] e : matrix) System.out.println(Arrays.toString(e));

    }

    public static void rotate90(int[][] matrix){
        // time - comp O(3 * m * n)
        // space comp - O(m * n)
        int rows = matrix.length;
        int col = matrix[0].length;
        int[][] transposed = new int[col][rows]; // only if rows != col

        for (int i = 0; i < rows; i++) { // O(m*n)
            for (int j = 0; j < col; j++) {
                 transposed[j][i] = matrix[i][j];
            }
        }

        for (int[] e : transposed){ // O(m*n)
            reverse(e,e.length - 1);
        }

        for (int i = 0; i < transposed.length; i++) { // O(m*n)
            System.arraycopy(transposed[i], 0, matrix[i], 0, transposed[0].length);
        }
    }
    private static void reverse(int[] arr , int s){
        int start = 0;
        int end = s;

        while (start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotate(int[][] matrix){
        // time - comp O(2 * m * n)
        // space comp - O(1)
        int rows = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < rows; i++) { // O(m*n)
            for (int j = i + 1; j < col; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int[] e : matrix){ // O(m*n)
            reverse(e,e.length - 1);
        }
    }



}
