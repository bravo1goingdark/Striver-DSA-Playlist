package Tree;


import java.util.LinkedList;
import java.util.Queue;

public class PartXIII {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return -1;
        Queue<Pair<TreeNode, Long>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0L));
        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int lvlSize = queue.size();
            long minIndex = queue.peek().index;
            long first = 0;
            long last = 0;

            for (int i = 0; i < lvlSize; i++) {
                Pair<TreeNode, Long> obj = queue.poll();
                long currIndex = obj.index - minIndex;
                if (i == 0) first = currIndex;
                if (i == lvlSize - 1) last = currIndex;

                if (obj.node.left != null) queue.add(new Pair<>(obj.node.left, 2 * currIndex + 1));
                if (obj.node.right != null) queue.add(new Pair<>(obj.node.right, 2 * currIndex + 2));

            }
            maxWidth = Math.max(maxWidth, (int)(last - first + 1));
        }
        return maxWidth;
    }

    private static class Pair<T, I> {
        public T node;
        public I index;

        public Pair(T node, I index) {
            this.node = node;
            this.index = index;
        }
    }
}
