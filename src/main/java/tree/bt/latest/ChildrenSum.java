package tree.bt.latest;

import java.util.Optional;

/*
Problem Statement: Given a Binary Tree, convert the value of its nodes to follow the Children Sum Property. The Children Sum Property in a binary tree states that for every node, the sum of its children's values (if they exist) should be equal to the node's value. If a child is missing, it is considered as having a value of 0.

Note:
The node values can be increased by any positive integer any number of times, but decrementing any node value is not allowed.
A value for a NULL node can be assumed as 0.
We cannot change the structure of the given binary tree.
 */
public class ChildrenSum {

    public void solve(TreeNode root) {
        if (root == null) {
            return;
        }

        int childSum = Optional.ofNullable(root.left).map(n -> n.data).orElse(0) +
                Optional.ofNullable(root.right).map(n -> n.data).orElse(0);

        if (childSum > root.data) {
            root.data = childSum;
        } else {
            if (root.left != null) root.left.data = childSum;
            if (root.right != null) root.right.data = childSum;
        }

        solve(root.left);
        solve(root.right);

        int totalSum = Optional.ofNullable(root.left).map(n -> n.data).orElse(0) +
                Optional.ofNullable(root.right).map(n -> n.data).orElse(0);
        if (root.left != null || root.right != null) {
            root.data = totalSum;
        }
    }
}
