import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PartVII {
    public static void main(String[] args) {
        System.out.println(majorityEle(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println(mooreVotingAlgo(new int[]{7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 5, 5, 5, 5}));

    }

    public static int majorityEle(int[] arr) {
        // time comp - O(N2)
        // space comp - O(N)
        for (int e : arr) {
            int count = 0;
            for (int it : arr) {
                if (e == it) {
                    count++;
                }
            }
            if (count > arr.length / 2) {
                return e;
            }
        }
        return -1;
    }

    public static int majorityElement(int[] arr) {
        // time comp - O(2N)
        // space comp - O(N)
        Map<Integer, Integer> map = new HashMap<>();

        for (int e : arr) {
            if (map.containsKey(e)) {
                map.put(e, map.getOrDefault(e, 0) + 1);
            } else {
                map.put(e, 1);
            }
        }
        for (Integer it : map.keySet()) {
            if (map.get(it) > arr.length / 2) {
                return it;
            }
        }
        return -1;

    }

    public static int mooreVotingAlgo(int[] arr) {
        int element = 0;
        int count = 0;

        for (int e : arr) {
            if (count == 0) {
                element = e;
                count++;
            } else if (e == element) count++;
            else count--;
        }

        int tc = 0;
        for (int e : arr) if (e == element) tc++;
        if (tc > arr.length / 2) return element;
        return -1;
    }

    public static int mostFrequentEven(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int result = Integer.MIN_VALUE;

        for (int e : arr) {
            if (e % 2 == 0) {
                int freq = map.getOrDefault(e, 0) + 1;
                map.put(e, freq);
                if (freq > maxFreq || freq == maxFreq && e < result){
                    maxFreq = freq;
                    result = e;
                }
            }
        }

        return result == Integer.MIN_VALUE ? -1 : result;
    }
}
