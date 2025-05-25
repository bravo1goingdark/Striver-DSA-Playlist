import java.util.HashMap;
import java.util.Map;

public class PartIV {
    public static void main(String[] args) {
        System.out.println(longestSubWithSumK(new int[]{1, 2, 1,3}, 2));
    }

    public static int longestSubWithSumKN3(int[] arr, int k) {
        int len = Integer.MIN_VALUE;
        // time comp - nearly not O(N3)
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int l = i; l <= j; l++) {
                    sum += arr[l];
                    if (sum == k) {
                        len = Math.max(len, j - i + 1);
                    }
                }
            }
        }
        return len;
    }

    public static int longestSubWithSumKN2(int[] arr, int k) {
        int len = Integer.MIN_VALUE;
        // time comp O(N2)
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        return len;
    }

    public static int longestSubWithSumKN(int[] arr, int k) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == k) {
                maxLen = i + 1;
            }

            if (prefixSumMap.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - prefixSumMap.get(sum - k));
            }

            if (!prefixSumMap.containsKey(sum)) {
                prefixSumMap.put(sum, i);
            }
        }
        return maxLen;
    }

    public static int longestSubWithSumK(int[] arr , long k){
        int f = 0;
        int s = 0;
        long sum = 0;
        int len = 0;

        while (s < arr.length){
            sum += arr[s];

            while (f <= s && sum > k) {
                sum -= arr[f];
                f++;
            }

            if (sum == k){
                len = Math.max(len , s - f + 1);
            }
            s++;
        }

        return len == 0 ? -1 : len;
    }


}
