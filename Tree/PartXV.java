package Tree;

import java.util.*;

public class PartXV {


    public static void mapParents(TreeNode root, Map<TreeNode, TreeNode> map) {
        if (root == null) return;

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

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();
        mapParents(root, map);
        Set<TreeNode> visited = new HashSet<>();
        int distance_counter = 0;

        queue.add(target);
        visited.add(target);

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (distance_counter == k) break;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null && !visited.contains(node.left)) {
                    queue.add(node.left);
                    visited.add(node.left);
                }

                if (node.right != null && !visited.contains(node.right)) {
                    queue.add(node.right);
                    visited.add(node.right);
                }

                TreeNode parent = map.get(node);
                if (parent != null && !visited.contains(parent)) {
                    queue.add(parent);
                    visited.add(parent);
                }

            }
            distance_counter++;
        }

        while (!queue.isEmpty()) {
            list.add(queue.poll().val);
        }
        return list;
    }
}
