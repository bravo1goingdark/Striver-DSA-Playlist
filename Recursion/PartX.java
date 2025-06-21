package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartX {
    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] arr = new int[]{2, 2, 1,2};
        boolean[] visited = new boolean[arr.length];
        Arrays.sort(arr); // sort the array first to remove duplicates
        permuteUnique(arr, visited, new ArrayList<>(), ans);
        System.out.println(ans);
    }

    public static void permuteUnique(int[] arr, boolean[] vis, List<Integer> curr, List<List<Integer>> ans) {
        if (arr.length == curr.size()) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            // remove duplicate
            if (i > 0 && arr[i] == arr[i - 1] && !vis[i - 1]) continue;

            if (!vis[i]) {
                vis[i] = true;
                curr.add(arr[i]);
                permuteUnique(arr, vis, curr, ans);
                curr.remove(curr.size() - 1);
                vis[i] = false;
            }
        }
    }
}
