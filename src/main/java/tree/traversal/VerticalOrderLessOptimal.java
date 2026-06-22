package tree.traversal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class VerticalOrderLessOptimal {

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(new VerticalOrderLessOptimal().solve(root));
    }

    public List<List<Integer>> solve(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<NodeData> list = new ArrayList<>();
        Queue<NodeData> q = new LinkedList<>();

        q.add(new NodeData(root, 0, 0));

        while (!q.isEmpty()) {
            NodeData temp = q.poll();
            list.add(temp);

            if (temp.node.left != null) {
                q.add(new NodeData(temp.node.left, temp.x + 1, temp.y - 1));
            }
            if (temp.node.right != null) {
                q.add(new NodeData(temp.node.right, temp.x + 1, temp.y + 1));
            }
        }

        list.sort(Comparator.comparing(NodeData::getY)
                .thenComparing(NodeData::getX)
                .thenComparingInt(NodeData::getNodeData)
        );

        Map<Integer, List<NodeData>> map = list.stream().collect(Collectors.groupingBy(NodeData::getY, LinkedHashMap::new, Collectors.toList()));

        List<List<Integer>> res = new ArrayList<>();
        for (List<NodeData> list1 : map.values()) {
            res.add(list1.stream().map(NodeData::getNodeData).toList());
        }

        return res;
    }

    private static class NodeData {
        Node node;
        int x;
        int y;

        public NodeData(Node node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }

        public Node getNode() {
            return node;
        }

        public int getNodeData() {
            return node.data;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
