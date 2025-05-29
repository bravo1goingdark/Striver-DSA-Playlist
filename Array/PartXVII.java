import java.util.HashMap;
import java.util.Map;

public class PartXVII {

    public static void main(String[] args) {
        System.out.println(subarraySumEqualKBrute(new int[]{1, 2, 3, -3, 1, 1, 1, 4, 2, -3}, 3));
        System.out.println(subarraySum(new int[]{1, 2, 3, -3, 1, 1, 1, 4, 2, -3}, 3));
    }


    public static int subarraySumEqualKBrute(int[] nums, int k) {
        // time comp - O(m*n)
        // space comp - O(1)

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) count++;
            }

        }
        return count;
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int prefixSum = 0;
        int count = 0;

        map.put(0, 1);
        while (start < nums.length) {
            prefixSum += nums[start];

            if (map.containsKey(prefixSum - k)) {

                count += map.get(prefixSum - k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);

            start++;
        }

        return count;
    }

    public static boolean checkSubarraySumBrute(int[] nums, int k) {
        // A good subarray is a subarray where:
        // 1 -> its length is at least two, and
        // 2 -> the sum of the elements of the subarray is a multiple of k.
        // time comp = O(n*n)
        // space comp = O(1)
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (j - i + 1 >= 2 && sum % k == 0) return true;
            }

        }
        return false;
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // to handle the case when subarray starts from index 0
        int prefixSum = 0;
        int start = 0;

        while (start < nums.length) {
            prefixSum += nums[start];
            int mod = k != 0 ? prefixSum % k : prefixSum;

            if (map.containsKey(mod) && start - map.get(mod) >= 2) {
                return true;
            } else {
                map.put(mod, start);
            }

            start++;
        }
        return false;
    }


}
