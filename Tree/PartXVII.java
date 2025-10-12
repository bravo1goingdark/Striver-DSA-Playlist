package Tree;

public class PartXVII {


    int count = 0;

    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        count++;
        int left = countNodes(root.left);
        if (left == 0) return 0;

        return countNodes(root.right);
    }

    public int countNodesOpt(TreeNode root) {
        if (root == null) return 0;

        int left = getHeightLeft(root);
        int right = getHeightRight(root);

        if (left == right) return (2 << left) - 1;

        return 1 + countNodesOpt(root.left) + countNodesOpt(root.right);
    }

    private int getHeightLeft(TreeNode root){
        if (root == null) return 0;
        int count = 0;

        while (root.left != null){
            count++;
            root = root.left;
        }
        return count;
    }

    private int getHeightRight(TreeNode root){
        if (root == null) return 0;
        int count = 0;

        while (root.right != null){
            count++;
            root = root.right;
        }
        return count;
    }
}
