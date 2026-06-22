package tree.bt.latest.construct;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeFromInAndPost {

    /*
    * In postorder, root comes last → process from the end and build right subtree first.
    * */

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        int[] postIndex = new int[] {postorder.length - 1};
        int inStart = 0;
        int inEnd = inorder.length - 1;

        return buildTree(postorder, inorderMap, postIndex, inStart, inEnd);
    }

    private TreeNode buildTree(int[] postorder, Map<Integer, Integer> inorderMap, int[] postIndex, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postIndex[0]--]);
        int inIndex = inorderMap.get(root.data);

        root.right = buildTree(postorder, inorderMap, postIndex, inIndex + 1, inEnd);
        root.left = buildTree(postorder, inorderMap, postIndex, inStart, inIndex - 1);

        return root;
    }
}
