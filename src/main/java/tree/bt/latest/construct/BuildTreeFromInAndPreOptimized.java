package tree.bt.latest.construct;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeFromInAndPreOptimized {

    /*
     * In preorder, root comes first → process from the start and build left subtree first.
     * */

    public static void main(String[] args) {
        new BuildTreeFromInAndPreOptimized().buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        int[] preIndex = new int[] {0};
        int inStart = 0;
        int inEnd = inorder.length - 1;

        return buildTree(preorder, inorderMap, preIndex, inStart, inEnd);
    }

    private TreeNode buildTree(int[] preorder, Map<Integer, Integer> inorderMap, int[] preIndex, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex[0]++]);
        int mid = inorderMap.get(root.data);

        root.left = buildTree(preorder, inorderMap, preIndex, inStart, mid - 1);
        root.right = buildTree(preorder, inorderMap, preIndex, mid + 1, inEnd);

        return root;
    }
}
