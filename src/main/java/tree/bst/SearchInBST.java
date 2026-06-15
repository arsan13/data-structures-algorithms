package tree.bst;

public class SearchInBST {

    public Node search(Node root, int data) {
//        while (root != null && root.data != data) {
//            root = data < root.data ? root.left : root.right;
//        }
//        return root;

        if(root==null) {
            return null;
        }
        if(root.data == data) {
            return root;
        }

        if (root.data > data) {
            return search(root.left, data);
        }
        return search(root.right, data);
    }
}
