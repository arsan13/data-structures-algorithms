package tree.bst;

import java.util.ArrayList;
import java.util.List;

public class ConvertToBalancedBST {

	public Node balancedBST(Node root) {
		List<Node> list = new ArrayList<>();
		inorder(root, list);
		
		return listToBST(list, 0, list.size() - 1);
	}

	private void inorder(Node root, List<Node> list) {
		if (root == null)
			return;

		inorder(root.left, list);
		list.add(root);
		inorder(root.right, list);
	}
	
	// Build tree from inorder traversal
	private Node listToBST(List<Node> list, int start, int end) {
		if(start > end)
			return null;
		
		int mid = (start + end) / 2;
		Node node = list.get(mid);
		
		node.left = listToBST(list, start, mid - 1);
		node.right = listToBST(list, mid + 1, end);
		return node;
	}
}
