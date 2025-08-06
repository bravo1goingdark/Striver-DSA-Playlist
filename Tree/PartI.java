package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartI {

    public static int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        traverse(root, map);

        int maxFreq = 0;
        for (int freq : map.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }

        for (Map.Entry<Integer, Integer> kv : map.entrySet()) {
            int k = kv.getKey();
            int v = kv.getValue();
            if (v == maxFreq) {
                ans.add(k);
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void traverse(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return;

        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        traverse(root.left, map);
        traverse(root.right, map);
    }



}
