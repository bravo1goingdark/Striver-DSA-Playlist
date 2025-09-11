package Tree;

import java.util.ArrayList;
import java.util.List;

public class PartXI {
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
}
