package Bsearch;

public class PartXXIV {


    public static int[] findPeak2D(int[][] matrix) {

        int row = matrix[0].length;
        int start = 0;
        int end = row - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int maxIndex = findMaxInCol(matrix, mid);
            int left = mid - 1 >= 0 ? matrix[maxIndex][mid - 1] : -1;
            int right = mid + 1 < row ? matrix[maxIndex][mid + 1] : -1;

            int value = matrix[maxIndex][mid];
            if (value > left && value > right){
                return new int[]{maxIndex,mid};
            }
            else if (value < left) end = mid - 1;
            else start = mid + 1;
        }
        return new int[]{-1,-1};
    }

    private static int findMaxInCol(int[][] mat, int col) {

        int index = -1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < mat.length; i++) {
            if (mat[i][col] > max) {
                max = mat[i][col];
                index = i;
            }
        }
        return index;
    }
}
