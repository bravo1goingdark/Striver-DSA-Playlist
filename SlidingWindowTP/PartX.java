package SlidingWindowTP;

import java.util.HashMap;
import java.util.Map;

public class PartX {
    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i; j < nums.length; j++) {
                int v = nums[j];
                map.put(v, map.getOrDefault(v, 0) + 1);

                if (map.size() == k) {
                    count++;
                } else if (map.size() > k) {
                    break;
                }
            }
            map.clear();
        }
        return count;

    }

    public static int subarraysWithKDistinctBetter(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    public static int atMost(int[] nums, int k) {
        int count = 0;
        int l = 0;
        int r = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (r < nums.length) {
            int v = nums[r];
            map.put(v, map.getOrDefault(v, 0) + 1);

            while (map.size() > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }
}
