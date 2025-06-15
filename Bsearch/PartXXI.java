package Bsearch;

public class PartXXI {
    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {0, 0, 0},
                {0, 1, 1}
        };

        System.out.println(rowAndMaximumOnes(mat)[0] + " " + rowAndMaximumOnes(mat)[1]);
    }

    public static int[] rowAndMaximumOnes(int[][] mat) {
        int count = 0;
        int index = -1;

        for (int i = 0; i < mat.length; i++) {
            int[] e = mat[i];
            int pos = firstOccurrence(e,1);
            int count_max = (pos == -1) ? 0 : e.length - pos;

            if (count_max > count) {
                count = count_max;
                index = i;
            }
        }
        return new int[]{index , count};
    }

    public static int firstOccurrence(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int first = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                first = mid;
                end = mid - 1;
            } else if (arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return first;
    }
}
