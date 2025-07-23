package SlidingWindowTP;

import javax.sql.rowset.BaseRowSet;

public class PartII {
    public static void main(String[] args) {
        System.out.println(longestSubArraySumLessEqualKBetter(new int[]{2, 5, 1, 7, 10}, 14));
    }

    public static int longestSubArraySumLessEqualKBrute(int[] arr, int k) {


        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum <= k) {
                    max = Math.max(max, j - i + 1);
                }
                if (sum > k) break;
            }
        }
        return max;

    }

    public static int longestSubArraySumLessEqualKBetter(int[] arr, int k) {

        int maxlen = 0;
        int sum = 0;
        int left = 0;
        int right = 0;

        while (right < arr.length) {
            sum += arr[right];

            while (sum > k && left <= right) {
                sum -= arr[left];
                left++;
            }

            if (sum <= k) maxlen = Math.max(maxlen, right - left + 1);
            right++;
        }

        return maxlen;
    }

    public static int longestSubArraySumLessEqualKOpt(int[] arr, int k) {

        int maxlen = 0;
        int sum = 0;
        int left = 0;
        int right = 0;

        while (right < arr.length) {
            sum += arr[right];

            // only change from while -> if
            if (sum > k && left <= right) {
                sum -= arr[left];
                left++;
            }

            if (sum <= k) maxlen = Math.max(maxlen, right - left + 1);
            right++;
        }

        return maxlen;
    }


}
