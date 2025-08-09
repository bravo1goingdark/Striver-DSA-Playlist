package Tree;
import com.sun.source.tree.Tree;

import java.util.Stack;

public class PartII {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        iterInOrder(root);
        System.out.println();
        iterPreOrder(root);
        System.out.println();
        iterPostOrder(root);
        System.out.println();

        iterPostOrderII(root);
    }

    public static void iterPreOrder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();

            System.out.print(curr.val + " ");
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
    }

    public static void iterInOrder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            System.out.print(curr.val + " ");

            curr = curr.right;
        }
    }

    // two stack
    public static void iterPostOrder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);



        while (!stack1.isEmpty()) {
            TreeNode curr = stack1.pop();
            stack2.push(curr);

            if (curr.left != null) stack1.push(curr.left);
            if (curr.right != null) stack1.push(curr.right);

        }

        while (!stack2.isEmpty()){
            System.out.print(stack2.pop().val + " ");
        }
    }

    // one stack
    public static void iterPostOrderII(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode lastVis = null;

        while (!stack.isEmpty() || curr != null){
            if (curr != null){
                stack.push(curr);
                curr = curr.left;
            }else {
                TreeNode top = stack.peek();

                if (top.right != null && lastVis != top.right){
                    curr  = top.right;
                }else {
                    System.out.print(top.val + " ");
                    lastVis = stack.pop();
                }
            }
        }
    }
}
