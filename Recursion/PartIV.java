package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PartIV {
    public static void main(String[] args) {
        System.out.println(subSeq(new int[]{3,2,1} ,0 , new ArrayList<>() , new ArrayList<>()));
    }


    public static List<List<Integer>> subSeq(int[] arr , int index ,List<Integer> curr, List<List<Integer>> ans){

        if (index >= arr.length){
            ans.add(new ArrayList<>(curr));
            return ans;
        }

        curr.add(arr[index]);
        subSeq(arr , index + 1 , curr,ans);
        curr.remove(curr.size() - 1);
        subSeq(arr,index + 1,curr,ans);

        return ans;
    }
}
