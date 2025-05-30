import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartXIX {

    public static List<Integer> majorityEleII(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        // time comp - O(N2)
        // space comp - O(N)
        for (int e : arr) {
            int count = 0;
            for (int it : arr) {
                if (e == it) {
                    count++;
                }
            }
            if (count > arr.length / 3 && !ans.contains(e)) {
                ans.add(e);
            }
        }
        return ans;
    }

    public static List<Integer> majorityElement(int[] arr) {
        // time comp - O(2N)
        // space comp - O(N)
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();


        for (int e : arr) {
            if (map.containsKey(e)) {
                map.put(e, map.getOrDefault(e, 0) + 1);
            } else {
                map.put(e, 1);
            }
        }
        for (Integer it : map.keySet()) {
            if (map.get(it) > arr.length / 3) {
                ans.add(it);
            }
        }
        return ans;

    }

    public static List<Integer> mooreVotingAlgo(int[] arr) {
        // time comp - O(2N)
        // space comp - O(1)
        List<Integer> ans = new ArrayList<>();

        int element1 = 0;
        int count1 = 0;
        int element2 = 0;
        int count2 = 0;

        for (int e : arr) {
            if (count1 == 0 && element2 != e) {
                element1 = e;
                count1 = 1;
            } else if (count2 == 0 && element1 != e) {
                count2 = 1;
                element2 = e;
            } else if (e == element1) count1++;
            else if (e == element2) count2++;
            else {
                count1--;
                count2--;
            }
            ;
        }

        count1 = 0;
        count2 = 0;
        for (int e : arr) {
            if (e == element1) count1++;
            else if (e == element2) count2++;

        };
        if (count1 > arr.length / 3) ans.add(element1);
        if (element1 != element2 && count2 > arr.length / 3) ans.add(element2); // prevent duplicates
        return ans;
    }
}
