package Tree;

import java.util.*;

public class PartIX {

    public static List<Integer> getTopView(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, root));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            int hd = curr.hd;
            TreeNode node = curr.node;


            if (!map.containsKey(hd)) {
                map.put(hd, node.val);
            }

            if (node.left != null) queue.add(new Pair(hd - 1, node.left));
            if (node.right != null) queue.add(new Pair(hd + 1, node.right));
        }

        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> v : map.entrySet()) {
            ans.add(v.getValue());
        }
        return ans;
    }

    public static List<Integer> bottomView(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, root));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            int hd = curr.hd;
            TreeNode node = curr.node;


            /// the only difference between top and bottom view is
            /// in top view -> we only insert in map if that key is not already in the map
            /// in bottom view -> we do not check if there is a key or not , if there is we simple overwrite the key
            map.put(hd, node.val);

            if (node.left != null) queue.add(new Pair(hd - 1, node.left));
            if (node.right != null) queue.add(new Pair(hd + 1, node.right));
        }

        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> v : map.entrySet()) {
            ans.add(v.getValue());
        }
        return ans;
    }

    public List<Integer> leftView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int levelsize = que.size();
            for (int i = 0; i < levelsize; i++) {
                TreeNode currNode = que.poll();
                if (currNode == null) break;

                if (i == 0) result.add(currNode.val);

                if (currNode.left != null) que.add(currNode.left);
                if (currNode.right != null) que.add(currNode.right);
            }
        }
        return result;
    }

    public List<Integer> rightView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int levelsize = que.size();
            for (int i = 0; i < levelsize; i++) {
                TreeNode currNode = que.poll();
                if (currNode == null) break;

                if (i == levelsize - 1) result.add(currNode.val);

                if (currNode.left != null) que.add(currNode.left);
                if (currNode.right != null) que.add(currNode.right);
            }
        }
        return result;
    }

    private static class Pair {
        public int hd;
        public TreeNode node;


        public Pair(int hd, TreeNode node) {
            this.hd = hd;
            this.node = node;
        }
    }
}
