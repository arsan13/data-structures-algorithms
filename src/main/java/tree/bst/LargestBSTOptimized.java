package tree.bst;

public class LargestBSTOptimized {

    public int largestBst(TreeNode root) {
        return largestBstUtil(root).size;
    }

    private TreeData largestBstUtil(TreeNode root) {
        if (root == null) {
            return new TreeData(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        TreeData leftData = largestBstUtil(root.left);
        TreeData rightData = largestBstUtil(root.right);

        if (leftData.maxValue < root.val && root.val < rightData.minValue) {
            // Valid BST
            return new TreeData(
                    1 + leftData.size + rightData.size,
                    Math.min(leftData.minValue, root.val),
                    Math.max(rightData.maxValue, root.val)
            );
        }

        //Not a valid BST, make parent invalid BST
        return new TreeData(Math.max(leftData.size, rightData.size), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private record TreeData(int size, int minValue, int maxValue) {
    }
}
