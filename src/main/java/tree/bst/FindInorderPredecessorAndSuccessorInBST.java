package tree.bst;

import java.util.Arrays;
import java.util.List;

public class FindInorderPredecessorAndSuccessorInBST {

    /*
    * Approach 1: Create a list from inorder traversal, which will be in sorted order, just return next element of the key. T-O(N), S-O(N).
    * Approach 2: Do inorder traversal and return first greater element. T-O(N)
    * Approach 3: Traverse left if key is less than root and also store it as successor. Traverse right if key is greater than root. T-O(logN)
    */
    public TreeNode getInorderSuccessor(TreeNode root, int key) {
        TreeNode res = null;
        while (root != null) {
            if (key < root.val) {
                res = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
    }

    public TreeNode getInorderPredecessor(TreeNode root, int key) {
        TreeNode res = null;
        while (root != null) {
            if (key > root.val) {
                res = root;
                root = root.right;
            } else {
                root = root.left;

            }
        }
        return res;
    }

    /*
    * If node < key, it can be the predecessor, so move to the right subtree to find a larger value still < key.
    * If node > key, it can be the successor, so move to the left subtree to find a smaller value still > key.
    * If node = key(assume root), predecessor is the maximum in left subtree and successor is the minimum in right subtree.
    */
    public List<TreeNode> getInorderPredecessorAndSuccessor(TreeNode root, int key) {
        TreeNode pre = null;
        TreeNode suc = null;

        while (root != null) {
            if (key > root.val) {
                pre = root;
                root = root.right;
            } else if (key < root.val) {
                suc = root;
                root = root.left;
            } else  {
                if (root.left != null) {
                    pre = rightMost(root.left);
                }
                if (root.right != null) {
                    suc = leftMost(root.right);
                }
                break;
            }
        }

        return Arrays.asList(pre, suc);
    }

    private TreeNode leftMost(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private TreeNode rightMost(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
}
