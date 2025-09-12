package Tree;

import java.util.ArrayList;
import java.util.List;

public class PartXI {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);

        root.right.right = new TreeNode(5);

        // test root-to-node path by VALUE
        System.out.println(getPath(root, 5)); // ?
        System.out.println(getPath(root, 7)); // ?
        System.out.println(getPath(root, 4)); // ?
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        allPath(root, "", res);
        return res;
    }

    private static void allPath(TreeNode root, String curr, List<String> res) {
        if (root.left == null && root.right == null) {
            res.add(curr + root.val);
            return;
        }

        curr += root.val + "->";

        if (root.left != null) allPath(root.left, curr, res);
        if (root.right != null) allPath(root.right, curr, res);
    }

    public static List<Integer> getPath(TreeNode root, int target) {
        List<Integer> ans = new ArrayList<>();
        if (rootToTarget(root, ans, target)) return ans;
        return new ArrayList<>();
    }

    private static boolean rootToTarget(TreeNode root, List<Integer> ans, int target) {
        if (root == null) return false;

        ans.add(root.val);
        if (root.val == target) return true;

        if (rootToTarget(root.left, ans, target) || rootToTarget(root.right, ans, target)) {
            return true;
        }

        ans.remove(ans.size() - 1);

        return false;
    }
}
