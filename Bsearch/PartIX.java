package Bsearch;

import java.util.Arrays;

public class PartIX {

    public static int koko(int[] arr, int hourly) {

        int start = 1;
        int end = getMax(arr);

        while (start <= end){
            int mid = start + (end - start) / 2;
            int req = totalHour(arr,mid);

            if (req <= hourly) end = mid - 1;
            else start = mid + 1;
        }
        return start;

    }

    private static int totalHour(int[] arr, int hourly) {
        double total = 0;

        for (int e : arr) total += Math.ceil(((double) e / (double) hourly));
        return (int) total;
    }


    private static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int e : arr) max = Math.max(max, e);
        return max;
    }
}
