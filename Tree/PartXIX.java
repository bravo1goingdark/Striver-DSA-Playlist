package Tree;

import java.util.HashMap;
import java.util.Map;

public class PartXIX {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0 || inorder.length == 0) return null;

        // Map each inorder value to its index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(postorder, 0, postorder.length - 1,
                inorder, 0, inorder.length - 1, map);
    }

    private TreeNode build(int[] postorder, int postStart, int postEnd,
                           int[] inorder, int inStart, int inEnd,
                           Map<Integer, Integer> map) {
        if (postStart > postEnd || inStart > inEnd) return null;

        // Last element in postorder = root
        TreeNode root = new TreeNode(postorder[postEnd]);

        // Root index in inorder
        int inRoot = map.get(root.val);
        int leftSize = inRoot - inStart;

        // Build left and right subtrees
        root.left = build(postorder, postStart, postStart + leftSize - 1,
                inorder, inStart, inRoot - 1, map);

        root.right = build(postorder, postStart + leftSize, postEnd - 1,
                inorder, inRoot + 1, inEnd, map);

        return root;
    }

}
