package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PartV {

    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] arr = new int[]{1,2,3};

        subSumEqK(arr,0,3,new ArrayList<>(),ans);
        System.out.println(ans);
        System.out.println(subSumEqKCount(new int[]{1,1,1,1,1},0,3));
    }


    public static void
    subSumEqK(int[] arr, int index, int sum, List<Integer> curr, List<List<Integer>> ans) {
        if (sum == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (index >= arr.length || sum < 0){
            return ;
        }

        curr.add(arr[index]);
        subSumEqK(arr, index + 1, sum - arr[index], curr, ans);
        curr.remove(curr.size() - 1);
        subSumEqK(arr,index + 1 , sum , curr , ans);
    }
    public static int subSumEqKCount(int[] arr, int index, int sum) {
        if (sum == 0) {
            return 1;
        }
        if (index >= arr.length){
            return 0;
        }

        int left = subSumEqKCount(arr, index + 1, sum - arr[index]);
        int right = subSumEqKCount(arr,index + 1 , sum);

        return left + right;
    }

}
