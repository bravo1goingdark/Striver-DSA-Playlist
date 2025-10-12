package Tree;

import java.util.*;

public class PartXVI {


    public int amountOfTime(TreeNode root, int start) {
        TreeNode target = findNode(root, start);
        return amountOfTimeHelper(root, target);
    }

    public int amountOfTimeHelper(TreeNode root, TreeNode target) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Set<TreeNode> visited = new HashSet<>();
        mapParents(root, map);
        int time = 0;

        queue.add(target);
        visited.add(target);

        while (!queue.isEmpty()) {
            boolean fireReachedThisLvl = false;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null && !visited.contains(node.left)) {
                    queue.add(node.left);
                    visited.add(node.left);
                    fireReachedThisLvl = true;
                }

                if (node.right != null && !visited.contains(node.right)) {
                    queue.add(node.right);
                    visited.add(node.right);
                    fireReachedThisLvl = true;
                }

                TreeNode parent = map.get(node);
                if (parent != null && !visited.contains(parent)) {
                    queue.add(parent);
                    visited.add(parent);
                    fireReachedThisLvl = true;
                }

            }
            if (fireReachedThisLvl) time++;
        }

        return time;
    }

    private static void mapParents(TreeNode root, Map<TreeNode, TreeNode> map) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                map.put(node.left, node);
                queue.offer(node.left);
            }

            if (node.right != null) {
                map.put(node.right, node);
                queue.offer(node.right);
            }
        }
    }


    private TreeNode findNode(TreeNode root, int start) {
        if (root == null) return null;
        if (root.val == start) return root;

        TreeNode left = findNode(root.left, start);
        if (left != null) return left;

        return findNode(root.right, start);
    }

}