package BitManipulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PartV {
    public static void main(String[] args) {
        System.out.println(singleNumberIIBetterII(new int[]{1, 1, 1, 2, 2, 2, 3, 4, 4, 4}));
    }

    public static int singleNumber(int[] nums) {
        int xor = 0;
        for (int e : nums) xor = xor ^ e;
        return xor;
    }

    public static int singleNumberII(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int e : nums) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }

        for (Integer k : map.keySet()) {
            if (map.get(k) == 1) {
                return k;
            }
        }
        return -1;
    }

    public static int singleNumberIIBetter(int[] nums) {
        int ans = 0;

        for (int bitIndex = 0; bitIndex < 32; bitIndex++) {
            int count = 0;

            for (int e : nums) {
                if ((e & (1 << bitIndex)) != 0)
                    count++;
            }

            if (count % 3 == 1) {
                ans = ans | (1 << bitIndex);
            }

        }
        return ans;
    }

    public static int singleNumberIIBetterII(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i = i + 3) {
            if (nums[i] != nums[i - 1]) {
                return nums[i - 1];
            }
        }
        return nums[nums.length - 1];
    }

    public static int singleNumberOpt(int[] nums) {
        int ones = 0;
        int twos = 0;


        for (int e : nums) {
            ones = (e ^ ones) & ~twos;
            twos = (e ^ twos) & ~ones;
        }
        return ones;
    }

    public int[] singleNumberIII(int[] nums) {
        long xor = 0;

        for (int e : nums) xor = xor ^ e;
        long rightMostSetBit = (xor & (xor - 1)) & xor;

        int b1 = 0;
        int b2 = 0;

        for (int e : nums) {
            if ((e & rightMostSetBit) != 0) b1 = b1 ^ e;
            else b2 = b2 ^ e;
        }

        return new int[]{b1, b2};
    }
}
