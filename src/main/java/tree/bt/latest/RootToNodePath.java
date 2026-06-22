package tree.bt.latest;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(findPath(root, 5));
    }

    public static List<Integer> findPath(TreeNode root, int target) {
        List<Integer> path = new ArrayList<>();
        findPath(root, target, path);
        return path;
    }

    private static boolean findPath(TreeNode root, int target, List<Integer> path) {
        if (root == null) {
            return false;
        }

        path.add(root.data);

        if (root.data == target) {
            return true;
        }

        boolean left = findPath(root.left, target, path);
        boolean right = findPath(root.right, target, path);

        if (left || right) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }
}
