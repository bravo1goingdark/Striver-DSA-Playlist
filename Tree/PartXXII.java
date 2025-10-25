package Tree;

import java.util.Stack;

public class PartXXII {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(7);

        flattenMorris(root);

        TreeNode curr = root;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
    }

    public static void flattenRecur(TreeNode root) {
        if (root == null) return;

        flattenRecur(root.left);
        flattenRecur(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }

        curr.right = right;
    }

    public static void flattenIter(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();

            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);

            if (!stack.isEmpty()) curr.right = stack.peek();
            curr.left = null;
        }
    }

    public static void flattenMorris(TreeNode root) {
        if (root == null) return;

        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) {
                TreeNode pred = curr.left;

                while (pred.right != null) {
                    pred = pred.right;
                }

                // Connect right subtree to predecessor's right
                pred.right = curr.right;

                // Move left subtree to right
                curr.right = curr.left;
                curr.left = null;

            }
            curr = curr.right;
        }
    }
}
