import java.util.ArrayList;
import java.util.List;

public class PartXVI {
    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{
                { 1,  2,  3,  4,  5,  6},
                { 7,  8,  9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36}
        }));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int left = 0;
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;

        while (top <= bottom && left <= right){


            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom ; i++) {
                list.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom){
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }

                bottom--;
            }

            if (left <= right){
                for (int i = bottom; i >= top ; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }

        }

        return list;
    }
}
