package Tree;

import java.util.*;

public class PartVI {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(zigzagLevelOrder(root));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int lvlSize = queue.size();
            List<Integer> currList = new ArrayList<>();

            for (int i = 0; i < lvlSize; i++) {
                TreeNode curr = queue.poll();
                if (curr == null) break;

                if (leftToRight) currList.add(curr.val);
                else currList.add(0, curr.val);

                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }

            result.add(currList);
            leftToRight = !leftToRight;
        }
        return result;
    }


    /// reduces O(k) shifting at each alternative levels by using linkedlist for insertion at both end
    public static List<List<Integer>> zigzagLevelOrderOpt(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int lvlSize = queue.size();
            LinkedList<Integer> currList = new LinkedList<>();

            for (int i = 0; i < lvlSize; i++) {
                TreeNode curr = queue.poll();
                if (curr == null) break;

                if (leftToRight) currList.addLast(curr.val);
                else currList.addFirst(curr.val);

                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }

            result.add(currList);
            leftToRight = !leftToRight;
        }
        return result;
    }
}
