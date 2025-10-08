package Tree;

public class PartXIV {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(2);
        System.out.println(satisfyChildrenSumProperty(root));
    }

    public static boolean satisfyChildrenSumProperty(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        int left = root.left != null ? root.left.val : 0;
        int right = root.right != null ? root.right.val : 0;

        return root.val == (left + right) &&
                satisfyChildrenSumProperty(root.left) &&
                satisfyChildrenSumProperty(root.right);
    }


    public static void changeTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        int child = 0;
        if (root.left != null) child += root.left.val;
        if (root.right != null) child += root.right.val;

        if (child >= root.val) root.val = child;
        else {
            if (root.left != null) root.left.val = root.val;
            if (root.right != null) root.right.val = root.val;
        }

        changeTree(root.left);
        changeTree(root.right);

        int total = 0;
        if (root.left != null) total += root.left.val;
        if (root.right != null) total += root.right.val;

        if (root.left != null || root.right != null) root.val = total;
    }
}
