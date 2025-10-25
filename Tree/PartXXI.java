package Tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class PartXXI {


    public List<Integer> morrisInorder(TreeNode root) {
        if (root == null) new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                list.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode pred = curr.left;

                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    pred.right = curr; // make thread
                    curr = curr.left;
                } else {
                    pred.right = null; // remove thread
                    list.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return list;
    }

    public List<Integer> morrisPreOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                list.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode pred = curr.left;

                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                // we visit the node before making a thread
                if (pred.right == null) {
                    list.add(curr.val); // only diff betwn inorder and preorder
                    pred.right = curr; // make thread
                    curr = curr.left;
                } else {
                    pred.right = null; // remove thread
                    curr = curr.right;
                }
            }
        }
        return list;
    }
}
