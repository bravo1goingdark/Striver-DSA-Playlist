package Bsearch;

import java.util.Arrays;

public class PartXII {
    public int shipWithinDays(int[] weights, int days) {
        int start = getMax(weights);
        int end = Arrays.stream(weights).sum();

        while (start <= end){
            int mid = start + (end - start) / 2;

            if (reqDays(weights,mid) <= days) end = mid - 1;
            else start = mid + 1;
        }

        return start;
    }

    private static int reqDays(int[] arr , int cap){
        int days = 0;
        int load = 0;

        for (int e : arr){
            if (load + e > cap) {
                days += 1;
                load = e;
            }
            else load += e;
        }
        return days + 1;
    }

    private static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int e : arr) {
            max = Math.max(max, e);
        };
        return max;
    }
}
