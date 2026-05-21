package tree.bt.latest;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                sb.append("# ");
                continue;
            }

            sb.append(node.data + " ");
            queue.add(node.left);
            queue.add(node.right);
        }


        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }

        String[] strArray = data.split(" ");

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strArray[0]));
        queue.add(root);

        for (int i = 1; i < strArray.length; i++) {
            TreeNode node = queue.poll();

            if (!strArray[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(strArray[i]));
                queue.add(left);
                node.left = left;
            }
            if (!strArray[++i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(strArray[i]));
                queue.add(right);
                node.right = right;
            }
        }

        return root;
    }
}
