package tree.bt.latest.group1;

import tree.bt.latest.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
Optimize by using graph
 */
public class MinimumTimeToBurnATree {

    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parentsMap = getParentsMap(root);
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode target = getTargetNode(root, start);
        queue.offer(target);
        visited.add(target);

        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            time++;

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if (current.left != null && !visited.contains(current.left)) {
                    queue.offer(current.left);
                    visited.add(current.left);
                }
                if (current.right != null && !visited.contains(current.right)) {
                    queue.offer(current.right);
                    visited.add(current.right);
                }
                if (parentsMap.get(current) != null && !visited.contains(parentsMap.get(current))) {
                    queue.offer(parentsMap.get(current));
                    visited.add(parentsMap.get(current));
                }
            }
        }
        return time;
    }

    private TreeNode getTargetNode(TreeNode root, int target) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.data == target) {
                return node;
            }

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return null;
    }

    private Map<TreeNode, TreeNode> getParentsMap(TreeNode root) {
        Map<TreeNode, TreeNode> parentsMap = new HashMap<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                parentsMap.put(node.left, node);
                queue.offer(node.left);
            }
            if (node.right != null) {
                parentsMap.put(node.right, node);
                queue.offer(node.right);
            }
        }

        return parentsMap;
    }
}
