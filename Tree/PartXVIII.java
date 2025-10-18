package Tree;

import java.util.HashMap;
import java.util.Map;

public class PartXVIII {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;

        // Map to store the index of each value in inorder traversal
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(0, preorder.length - 1, preorder, 0, inorder.length - 1, inorder, map);
    }

    private TreeNode buildTree(int preStart, int preEnd, int[] preorder,
                               int inStart, int inEnd, int[] inorder,
                               Map<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd) return null;

        // first element in preorder is the root
        TreeNode root = new TreeNode(preorder[preStart]);

        //  root index in inorder
        int inRoot = map.get(root.val);

        // Number of nodes in left subtree
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preStart + 1, preStart + numsLeft,
                preorder, inStart, inRoot - 1, inorder, map);
        root.right = buildTree(preStart + numsLeft + 1, preEnd,
                preorder, inRoot + 1, inEnd, inorder, map);

        return root;
    }
}
