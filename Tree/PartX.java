package Tree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class PartX {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()){
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();

            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;

            queue.offer(t1.left);
            queue.offer(t2.right);

            queue.offer(t1.right);
            queue.offer(t2.left);
        }

        return true;
    }


    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isNull = false;


        while (!queue.isEmpty()) {
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
