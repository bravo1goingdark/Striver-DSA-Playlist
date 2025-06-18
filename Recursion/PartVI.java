package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PartVI {
    public static void main(String[] args) {
        System.out.println(subSumEqK(new int[]{1,2,3} , 0,3 , new ArrayList<>()));


        System.out.println(letterCasePermutation("1a2b"));
    }


    // print any one subset that satisfy the sum equal k
    public static boolean
    subSumEqK(int[] arr, int index, int sum, List<Integer> curr) {
        if (sum == 0) {
            for (int e : curr) System.out.print(e + " ");
            return true;
        }
        if (index >= arr.length || sum < 0){
            return false;
        }

        curr.add(arr[index]);
        if (subSumEqK(arr, index + 1, sum - arr[index], curr)) return true;
        curr.remove(curr.size() - 1);
        return subSumEqK(arr, index + 1, sum, curr);
    }
    public static List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        letterCasePermutation(s,0, "" ,ans);
        return ans;
    }

    private static void letterCasePermutation(String s, int index, String curr , List<String> ans) {
        if (index >= s.length()){
            ans.add(curr);
            return;
        }
        char ch = s.charAt(index);
        if (Character.isDigit(ch)){
            letterCasePermutation(s,index + 1 , curr + ch , ans);
        }else {
            // lowercase
            char lo = Character.toLowerCase(ch);
            letterCasePermutation(s,index + 1 , curr + lo , ans);

            //uppercase
            char up = Character.toUpperCase(ch);
            letterCasePermutation(s,index + 1 , curr + up , ans);

        }
    }
}
