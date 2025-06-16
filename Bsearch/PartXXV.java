package Bsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PartXXV {
    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1, 5, 7, 9, 11},
                {2, 3, 4, 5, 10},
                {9, 10, 12, 14, 16},

        };

        System.out.println(findMedian(mat));
    }

    public static int findMedianBrute(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                list.add(ints[j]);
            }
        }

        Collections.sort(list);

        return list.get((matrix.length * matrix[0].length) / 2);

    }

    public static int findMedian(int[][] mat) {

        int start = getMaxMin(mat)[0];
        int end = getMaxMin(mat)[1];

        int req = (mat.length * mat[0].length) / 2;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int c = countLessOrEqual(mat, mid);
            
            if (c <= req) start = mid + 1;
            else end = mid - 1;
        }
        return start;
    }

    private static int countLessOrEqual(int[][] mat, int value) {
        int count = 0;
        for (int[] e : mat) {
            count += upperBound(e, value);
        }
        return count;
    }

    private static int[] getMaxMin(int[][] mat) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int[] e : mat) {
            min = Math.min(min, e[0]);
            max = Math.max(max, e[mat[0].length - 1]);
        }
        return new int[]{min, max};
    }

    public static int upperBound(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int ans = arr.length;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > target) {
                ans = mid;
                end = mid - 1;
            } else start = mid + 1;
        }

        return ans;
    }
}
