package tree.bst;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConstructBSTFromPreorder {

    // Approach 1: O(N * N)
    public TreeNode bstFromPreorder1(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);

        for (int i = 1; i < preorder.length; i++) {
            insert(root, preorder[i]);
        }

        return root;
    }
    private void insert(TreeNode root, int val) {
        TreeNode curr = root;
        TreeNode prev = null;

        while (curr != null) {
            prev = curr;
            curr = curr.val > val ? curr.left : curr.right;
        }

        if (prev.val > val) {
            prev.left = new TreeNode(val);
        } else {
            prev.right = new TreeNode(val);
        }
    }


    // Approach 2: O(N * logN)
    public TreeNode bstFromPreorder2(int[] preorder) {
        int[] inorder = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(inorder);

        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        int[] preIndex = new int[]{0};
        int inStart = 0;
        int inEnd = inorder.length - 1;

        return buildTree(preorder, inorderMap, preIndex, inStart, inEnd);
    }
    private TreeNode buildTree(int[] preorder, Map<Integer, Integer> inorderMap, int[] preIndex, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex[0]++]);
        int mid = inorderMap.get(root.val);

        root.left = buildTree(preorder, inorderMap, preIndex, inStart, mid - 1);
        root.right = buildTree(preorder, inorderMap, preIndex, mid + 1, inEnd);
        return root;
    }


    // Approach 2: O(3N = N)
    public TreeNode bstFromPreorder3(int[] preorder) {
        return bstFromPreorder(preorder, Long.MAX_VALUE, new int[]{0});
    }


    private TreeNode bstFromPreorder(int[] preorder, long bound, int[] index) {
        if (index[0] == preorder.length || preorder[index[0]] > bound) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[index[0]++]);
        root.left = bstFromPreorder(preorder, root.val, index);
        root.right = bstFromPreorder(preorder, bound, index);
        return root;
    }
}
