package tree.bt.latest.view;

import java.util.ArrayList;
import java.util.List;

public class SideView {

    public static List<Integer> sideView(Node root) {
        List<Integer> list = new ArrayList<>();

        rightView(root, 0, list);
//        leftView(root, 0, list);

        return list;
    }

    // The first encountered node at each level will be the rightmost node for that level.
    // So we can maintain a list and add the first encountered node at each level to the list.
    // We can do a pre-order traversal and visit the right child before the left child.
    private static void rightView(Node node, int level, List<Integer> list) {
        if (node == null) {
            return;
        }

        if (level == list.size()) {
            list.add(node.data);
        }

        rightView(node.right, level + 1, list);
        rightView(node.left, level + 1, list);
    }

    // The first encountered node at each level will be the leftmost node for that level.
    // So we can maintain a list and add the first encountered node at each level to the list.
    // We can do a pre-order traversal and visit the left child before the right child.
    private static void leftView(Node node, int level, List<Integer> list) {
        if (node == null) {
            return;
        }

        if (level == list.size()) {
            list.add(node.data);
        }

        leftView(node.left, level + 1, list);
        leftView(node.right, level + 1, list);
    }
}
