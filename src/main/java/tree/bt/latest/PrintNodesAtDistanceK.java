package tree.bt.latest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class PrintNodesAtDistanceK {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentsMap = getParentsMap(root);
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(target);
        visited.add(target);

        int level = 0;
        while (!queue.isEmpty() && level != k) {
            int size = queue.size();
            level++;

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

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.data);
        }
        return res;
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
