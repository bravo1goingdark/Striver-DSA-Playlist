package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PartIX {

    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] arr = new int[]{1, 2, 3};
        boolean[] visited = new boolean[arr.length];
        // Arrays.sort(arr) // sort the array first to remove duplicates
        // permute(arr, visited, new ArrayList<>(), ans);
        permutation(arr,0,ans);
        System.out.println(ans);
    }

    // approach 1
    public static void permute(int[] arr, boolean[] vis, List<Integer> curr, List<List<Integer>> ans) {
        if (arr.length == curr.size()) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < arr.length; i++) {

            if (!vis[i]) {
                vis[i] = true;
                curr.add(arr[i]);
                permute(arr, vis, curr, ans);
                curr.remove(curr.size() - 1);
                vis[i] = false;
            }
        }

    }


    // approach 2
    public static void permutation(int[] arr, int index, List<List<Integer>> ans) {
        if (index == arr.length) {
            List<Integer> curr = new ArrayList<>();
            for (int e : arr) curr.add(e);
            ans.add(curr);
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            permutation(arr, index + 1, ans);
            swap(arr, i, index);
        }

    }

    private static void swap(int[] arr, int f, int s) {
        int t = arr[f];
        arr[f] = arr[s];
        arr[s] = t;
    }


}
