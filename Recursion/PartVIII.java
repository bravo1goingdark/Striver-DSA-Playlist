package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PartVIII {

    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
//        subsetSum(new int[]{1,2,3} , 0,0,ans);
        subsetII(new int[]{1, 2, 2}, 0, new ArrayList<>(), ans);
        System.out.println(ans);
    }

    public static void subsetSum(int[] arr, int index, int currSum, List<Integer> ans) {
        if (index >= arr.length) {
            ans.add(currSum);
            return;
        }

        // pick
        subsetSum(arr, index + 1, currSum + arr[index], ans);

        // not pick
        subsetSum(arr, index + 1, currSum, ans);
    }

    public static void subsetII(int[] arr, int index, List<Integer> curr, List<List<Integer>> ans) {
        if (index >= arr.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        // pick
        curr.add(arr[index]);
        subsetII(arr, index + 1, curr, ans);
        curr.remove(curr.size() - 1);


        // remove duplicates
        int nInd = index + 1;
        while (nInd < arr.length && arr[index] == arr[nInd]) nInd++;

        // not pick
        subsetII(arr, nInd, curr, ans);
    }
}
