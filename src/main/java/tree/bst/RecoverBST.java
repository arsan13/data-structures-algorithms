package tree.bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecoverBST {

    // T-O(NlogN), S-O(N)
    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        Collections.sort(list);
        recoverTree(root, list, new int[]{0});
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    public void recoverTree(TreeNode root, List<Integer> list, int[] index) {
        if (root == null) {
            return;
        }

        recoverTree(root.left, list, index);

        int val = list.get(index[0]++);
        if (root.val != val) {
            root.val = val;
        }

        recoverTree(root.right, list, index);
    }
}
