package Bsearch;

import java.util.Arrays;

public class PartX {
    public static void main(String[] args) {
        System.out.println(minDays(new int[]{1,10,3,10,2},3,1));
    }


    public static int minDays(int[] bloomDay, int m, int k) {
        long v = (long) m * k;

        if (v > bloomDay.length) return -1;
        int start = getMaxMin(bloomDay)[0];
        int end = getMaxMin(bloomDay)[1];

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (isPossible(bloomDay, mid, m, k)) end = mid - 1;
            else start = mid + 1;
        }
        return start;
    }

    private static boolean isPossible(int[] arr, int day, int m, int k) {
        int count = 0;
        int noOfBouquet = 0;

        for (int e : arr) {
            if (e <= day) count++;
            else {
                noOfBouquet += count / k;
                count = 0;
            }
        }
        noOfBouquet += count / k;
        return noOfBouquet >= m;
    }

    private static int[] getMaxMin(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int e : arr) {
            max = Math.max(max, e);
            min = Math.min(min, e);
        };

        return new int[]{min, max};
    }

}
