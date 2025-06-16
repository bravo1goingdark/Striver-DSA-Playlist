package Bsearch;

public class PartXXII {
    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1,3,5,7},{10,11,16,20},{23,30,34,60}
        };

        System.out.println(searchMatrix(mat,3));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {

        for (int[] e : matrix){
            int f = e[0];
            int l = e[e.length - 1];

            if (f <= target && target <= l){
                return bs(e,target);
            }
        }
        return false;

    }
    public static boolean bs(int[] arr,int target){
        int start = 0;
        int end = arr.length - 1;

        while (start <= end){
            int mid = start + (end - start)/2;

            if (arr[mid] == target) return true;
            else if (arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }

        return false;
    }

    public static boolean flattenedBS(int[][] mat , int target){

        int start = 0;
        int end = mat.length * mat[0].length - 1;


        while (start <= end){
            int mid = start + (end - start) / 2;
            int row = mid / mat[0].length;
            int col = mid % mat[0].length;

            if (mat[row][col] == target) return true;
            else if (mat[row][col] < target) start = mid + 1;
            else end = mid - 1;
        }

        return false;
    }
}
