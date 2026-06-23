package tree.bst;


import java.util.ArrayList;
import java.util.List;

public class TwoSumInBST {

    // T-O(N), S-O(logN)
    public boolean existsOptimized(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        BSTIterator left = new BSTIterator(root, false);
        BSTIterator right = new BSTIterator(root, true);

        int i = left.next();
        int j = right.next();
        while (i < j) {
            int sum = i + j;
            if (sum == k) {
                return true;
            }
            if (sum > k) {
                j = right.next();
            } else  {
                i = left.next();
            }
        }

        return false;
    }

    // T-O(N), S-O(N)
    public boolean exists(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        inOrder(root, list); // Inorder List is sorted in BST
        return exists(list, k);
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
		inOrder(root.left, list);
		list.add(root.val);
		inOrder(root.right, list);
    }

    private boolean exists(List<Integer> list, int k) {
        int i = 0;
        int j = list.size() - 1;

        while (i < j) {
            int sum = list.get(i) + list.get(j);
            if (sum == k) {
                return true;
            }
            if (sum > k) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }
}
