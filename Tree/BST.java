package Tree;

import com.sun.security.auth.UnixNumericGroupPrincipal;

public class BST {


    public TreeNode searchInBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;

        while (root != null && root.val != val) {
            root = val > root.val ? root.right : root.left;
        }
        return root;
    }

    // smallest value in BST >= target → CEIL
    public int ceilInBST(TreeNode root, int target) {
        if (root == null) return -1;

        int ceil = -1;

        while (root != null) {
            if (root.val == target) return root.val;
            else if (root.val < target) root = root.right;
            else {
                ceil = root.val;
                root = root.left;
            }
        }
        return ceil;
    }

    // largest value in BST <= target → FLOOR
    public int floorInBST(TreeNode root, int target) {
        if (root == null) return -1;

        int floor = -1;

        while (root != null) {
            if (root.val == target) return root.val;
            else if (root.val > target) root = root.left;
            else {
                floor = root.val;
                root = root.right;
            }
        }
        return floor;
    }

    public TreeNode insertInBST(TreeNode root, int value) {
        if (root == null) return new TreeNode(value);

        if (value < root.val) root.left = insertInBST(root.left, value);
        else if (value > root.val) root.right = insertInBST(root.right, value);

        return root;
    }
}
