package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PartIII {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        allDfsTrav(root);
    }


    public static void allDfsTrav(TreeNode root) {
        if (root == null) return;


        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));


        while (!stack.isEmpty()) {
            Pair curr = stack.peek();

            if (curr.state == 1) {
                curr.state++;
                pre.add(curr.node.val);

                if (curr.node.left != null) {
                    stack.push(new Pair(curr.node.left, 1));
                }
            } else if (curr.state == 2){
                curr.state++;
                in.add(curr.node.val);

                if (curr.node.right != null){
                    stack.push(new Pair(curr.node.right , 1));
                }
            }else {
                post.add(curr.node.val);
                stack.pop();
            }
        }

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }

    private static class Pair {
        TreeNode node;
        int state;

        public Pair(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }
}
