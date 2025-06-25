package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PartXVII {
    public static void main(String[] args) {
        System.out.println(getPermutationOpt(4, 16));
    }

    public static String getPermutation(int n, int k) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) sb.append(i);

        permute(sb.toString().toCharArray(), 0, ans);
        return ans.get(k - 1);
    }

    private static void permute(char[] arr, int index, List<String> ans) {
        if (index == arr.length) {
            ans.add(new String(arr));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            permute(arr, index + 1, ans);
            swap(arr, i, index); // backtrack
        }
    }

    private static void swap(char[] arr, int f, int s) {
        char temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }

    public static String getPermutationOpt(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i < n; i++) {
            fact = fact * i;
            list.add(i);
        }
        list.add(n);
        StringBuilder ans = new StringBuilder();
        k = k - 1;

        while (true) {
            ans.append(list.get(k / fact));
            list.remove( k / fact);

            if (list.isEmpty()) break;

            k = k % fact;
            fact = fact / list.size();
        }
        return ans.toString();
    }


}
