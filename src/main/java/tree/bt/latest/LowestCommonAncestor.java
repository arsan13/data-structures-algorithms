package tree.bt.latest;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(findLCA(root, new TreeNode(4), new TreeNode(5)).data); // Output: 2
        System.out.println(findLCA(root, new TreeNode(4), new TreeNode(6)).data); // Output: 1
    }

    public static TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        /*
         * Brute force: Find root to node path for both p and q and return the latest common element of both the paths.
         */

        if(root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);

        if(left != null && right != null) {
            return root;
        }
        if(left != null) {
            return left;
        }
        return right;

    }
}
