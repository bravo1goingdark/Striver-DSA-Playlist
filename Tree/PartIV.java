package Tree;

import com.sun.source.tree.Tree;

public class PartIV {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxDepth(root));
        System.out.println(isBalanced(root));
        System.out.println(isBalancedOpt(root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);

    }

    public static boolean isBalanced(TreeNode root) {

        if (root == null) return true;
        if (Math.abs(height(root.left) - height(root.right)) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }


    public static boolean isBalancedOpt(TreeNode root) {
        return isBalancedHelper(root) != -1;
    }

    private static int isBalancedHelper(TreeNode root) {
        if (root == null) return 0;

        int left = isBalancedHelper(root.left);
        if (left == -1) return -1;
        int right = isBalancedHelper(root.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return 1 + Math.max(left, right);
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        h(root, diameter);
        return diameter[0];
    }

    private static int h(TreeNode root, int[] diameter) {
        if (root == null) return 0;

        int left = h(root.left, diameter);
        int right = h(root.right, diameter);

        diameter[0] = Math.max(diameter[0], left + right);

        return 1 + Math.max(left, right);
    }
}
