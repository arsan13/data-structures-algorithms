package tree.bst;

public class SearchInBST {

    public TreeNode search(TreeNode root, int data) {
//        while (root != null && root.data != data) {
//            root = data < root.data ? root.left : root.right;
//        }
//        return root;

        if(root==null) {
            return null;
        }
        if(root.val == data) {
            return root;
        }

        if (root.val > data) {
            return search(root.left, data);
        }
        return search(root.right, data);
    }
}
