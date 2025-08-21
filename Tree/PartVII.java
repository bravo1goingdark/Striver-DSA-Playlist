package Tree;


import java.util.ArrayList;
import java.util.List;

public class PartVII {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        root.right.right = new TreeNode(25);

        System.out.println(traverseBoundary(root));
        // [20, 8, 4, 10, 14, 25, 22]
    }


    public static List<Integer> traverseBoundary(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        if (!isLeaf(root)) res.add(root.val);
        addLeftNodes(root.left, res);
        addLeaves(root, res);
        addRightNodes(root.right, res);

        return res;
    }

    private static void addLeftNodes(TreeNode root, List<Integer> res) {
        if (root == null) return;

        while (root != null) {
            if (!isLeaf(root)) res.add(root.val);
            root = root.left != null ? root.left : root.right;
        }
    }

    private static void addLeaves(TreeNode root, List<Integer> res) {
        if (root == null) return;

        if (isLeaf(root)) {
            res.add(root.val);
            return;
        }
        ;
        addLeaves(root.left, res);
        addLeaves(root.right, res);
    }

    private static void addRightNodes(TreeNode root, List<Integer> res) {
        if (root == null) return;
        List<Integer> temp = new ArrayList<>();

        while (root != null) {
            if (!isLeaf(root)) temp.add(root.val);
            root = root.right != null ? root.right : root.left;
        }
        for (int i = temp.size() - 1; i >= 0; i--) res.add(temp.get(i));
    }

    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
