package Tree;

public class PartV {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(-9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPath(root, max);
        return max[0];
    }

    private static int maxPath(TreeNode root, int[] max) {
        if (root == null) return 0;

        // ignore negative node value
        int left = Math.max(0, maxPath(root.left, max));
        int right = Math.max(0, maxPath(root.right, max));

        // checks for max path through this node
        int pathSum = left + right + root.val;

        // updates global maximum
        max[0] = Math.max(max[0], pathSum);

        // returned upward to parent (extendable path).
        return root.val + Math.max(left, right);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        // perform pre-order traversal
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        if (p.val != q.val) return false;
        boolean left = isSameTree(p.left, q.left);
        if (!left) return false;

        return isSameTree(p.right, q.right);
    }

}
