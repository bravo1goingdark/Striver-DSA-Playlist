package SlidingWindowTP;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PartVI {
    public static int totalFruitBrute(int[] fruits) {
        int maxLen = 0;

        for (int i = 0; i < fruits.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < fruits.length; j++) {
                set.add(fruits[j]);

                if (set.size() <= 2) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return maxLen;
    }

    public static int totalFruitBetter(int[] fruits) {

        int maxLen = 0;
        int left = 0;
        int right = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (right < fruits.length) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);


            if (map.size() > 2) {
                while (map.size() > 2) {
                    map.put(fruits[left], map.get(fruits[left]) - 1);
                    if (map.get(fruits[left]) == 0) {
                        map.remove(fruits[left]);
                    }
                    left++;
                }
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;

        }
        return maxLen;
    }

    public static int totalFruitOpt(int[] fruits) {

        int maxLen = 0;
        int left = 0;
        int right = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (right < fruits.length) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            if (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;

        }
        return maxLen;
    }
}
