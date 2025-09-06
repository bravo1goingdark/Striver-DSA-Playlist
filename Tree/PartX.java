package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class PartX {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode left, TreeNode right) {

        if (left == null || right == null) return left == right;

        if (left.val != right.val) return false;

        return isMirror(left.left, right.right) && isMirror(left.right, right.left);

    }

    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isNull = false;


        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node == null) isNull = true;
                else {
                    if (isNull) return false;
                    queue.offer(node.left);
                    queue.offer(node.right);
                }

            }
        }
        return true;
    }
}
