package tree.bt.latest;

import java.util.Stack;

public class FlattenTree {

    TreeNode prev = null;
    public void flattenRec(TreeNode root) {
        if (root == null) {
            return;
        }

        flattenRec(root.right);
        flattenRec(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }

    public void flattenIterative(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }

            if (!stack.isEmpty()) {
                node.right = stack.peek();
            }
            node.left = null;
        }
    }
}
