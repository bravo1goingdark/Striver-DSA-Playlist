package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartVII {
    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        System.out.println(min(mat, mat.length - 1, mat[0].length - 1));

        List<List<Integer>> ans = new ArrayList<>();
        int[] arr = new int[]{2,5,2,1,2};
        Arrays.sort(arr);
        combSumII(arr,0,5,new ArrayList<>(),ans);
        System.out.println(ans);
    }

    public static int min(int[][] grid, int row, int col) {
        if (row == 0 && col == 0) return grid[0][0];

        if (col < 0 || row < 0) return Integer.MAX_VALUE;

        int left = min(grid, row, col - 1);
        int up = min(grid, row - 1, col);

        return grid[row][col] + Math.min(left, up);
    }

    public static void combSum(int[] arr, int index, int target, List<Integer> curr, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (index >= arr.length || target < 0) return;

        // pick
        if (arr[index] <= target) {
            curr.add(arr[index]);
            combSum(arr, index, target - arr[index], curr, ans);
            curr.remove(curr.size() - 1);
        }

        // remove duplicates
        int nInd = index + 1;
        while (nInd < arr.length && arr[index] == arr[nInd]) nInd++;

        // not pick
        combSum(arr, nInd, target, curr, ans);
    }
    public static void combSumII(int[] arr, int index, int target, List<Integer> curr, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (index >= arr.length || target < 0) return;

        // pick
        if (arr[index] <= target) {
            curr.add(arr[index]);
            combSumII(arr, index + 1, target - arr[index], curr, ans);
            curr.remove(curr.size() - 1);
        }

        // remove duplicates
        int nInd = index + 1;
        while (nInd < arr.length && arr[index] == arr[nInd]) nInd++;

        // not pick
        combSumII(arr, nInd, target, curr, ans);
    }


}
