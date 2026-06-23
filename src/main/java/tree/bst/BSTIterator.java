package tree.bst;

import java.util.Stack;

public class BSTIterator {
    private final Stack<TreeNode> stack;
    private final boolean isReverse;

    public BSTIterator(TreeNode root, boolean isReverse) {
        stack = new Stack<>();
        this.isReverse = isReverse;
        pushAll(root);
    }

    public int next() {
        TreeNode node = stack.pop();

        if (isReverse) {
            pushAll(node.left);
        } else {
            pushAll(node.right);
        }

        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAll(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = isReverse ? root.right : root.left;
        }
    }
}
