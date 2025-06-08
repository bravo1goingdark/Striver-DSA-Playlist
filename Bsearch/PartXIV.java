package Bsearch;

import java.util.Arrays;

public class PartXIV {

    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int start = 1;
        int end = stalls[stalls.length - 1] - stalls[0];

        while (start <= end){
            int mid = start + (end - start) / 2;

            if (canWePlace(stalls,mid,k)) start = mid + 1;
            else end = mid - 1;
        }
        return end;

    }

    private static boolean canWePlace(int[] stalls , int distance , int cows){
        int noOfCows = 1;
        int lastCow = stalls[0];

        for (int e : stalls){
            if (e - lastCow >= distance) {
                noOfCows++;
                lastCow = e;
            }
        }
        return noOfCows >= cows;
    }
}
