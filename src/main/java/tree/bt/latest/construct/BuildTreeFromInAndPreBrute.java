package tree.bt.latest.construct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuildTreeFromInAndPreBrute {

    public static void main(String[] args) {
        buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }


    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(arrayToList(preorder), arrayToList(inorder));
    }

    private static TreeNode buildTree(List<Integer> preorder, List<Integer> inorder) {
        if (inorder.isEmpty() || preorder.isEmpty()) {
            return null;
        }

        TreeNode root = new TreeNode(preorder.getFirst());

        int index = inorder.indexOf(preorder.getFirst());
        preorder.removeFirst();

        root.left = buildTree(preorder, inorder.subList(0, index));
        root.right = buildTree(preorder, inorder.subList(index + 1, inorder.size()));

        return root;
    }

    private static List<Integer> arrayToList(int[] arr) {
        return new ArrayList<>(Arrays.stream(arr).boxed().toList());
    }
}
