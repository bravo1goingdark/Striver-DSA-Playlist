package Tree;

import java.util.*;

public class PartVIIII {

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(root, 0, 0));

        while (!queue.isEmpty()) {
            Tuple t = queue.poll();
            TreeNode node = t.node;
            int row = t.row;
            int col = t.col;

            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            map.get(col).get(row).add(node.val);

            if (node.left != null) queue.add(new Tuple(node.left, row + 1, col - 1));
            if (node.right != null) queue.add(new Tuple(node.right, row + 1, col + 1));
        }

        List<List<Integer>> result = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> cols : map.values()) {
            List<Integer> currList = new ArrayList<>();
            for (PriorityQueue<Integer> pq : cols.values()) {
                while (!pq.isEmpty()) currList.add(pq.poll());
            }

            result.add(currList);
        }
        return result;
    }


    private static class Tuple {
        public TreeNode node;
        public int row;
        public int col;

        public Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
}
