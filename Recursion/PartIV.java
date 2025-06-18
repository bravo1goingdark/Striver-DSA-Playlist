package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartIV {
    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] arr = new int[]{1,2,2};
        Arrays.sort(arr);
        subSeqDup(arr,0,new ArrayList<>(),ans);
        System.out.println(ans);
    }

    public static void subSeq(int[] arr , int index ,List<Integer> curr, List<List<Integer>> ans){
        // does not handle duplicates
        if (index >= arr.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        curr.add(arr[index]);
        subSeq(arr , index + 1 , curr,ans);
        curr.remove(curr.size() - 1);
        subSeq(arr,index + 1,curr,ans);
    }

    public static void subSeqDup(int[] arr , int index ,List<Integer> curr, List<List<Integer>> ans){
        // does handle duplicates
        if (index >= arr.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        curr.add(arr[index]);
        subSeqDup(arr , index + 1 , curr,ans);
        curr.remove(curr.size() - 1);

        // skip all same adjacent element
        int nextInd = index + 1;
        while (nextInd < arr.length && arr[index] == arr[nextInd]) nextInd++;

        subSeqDup(arr,nextInd,curr,ans);
    }
}
