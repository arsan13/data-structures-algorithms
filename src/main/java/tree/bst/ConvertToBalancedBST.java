package tree.bst;

import java.util.ArrayList;
import java.util.List;

public class ConvertToBalancedBST {

	public TreeNode balancedBST(TreeNode root) {
		List<TreeNode> list = new ArrayList<>();
		inorder(root, list);
		
		return listToBST(list, 0, list.size() - 1);
	}

	private void inorder(TreeNode root, List<TreeNode> list) {
		if (root == null)
			return;

		inorder(root.left, list);
		list.add(root);
		inorder(root.right, list);
	}
	
	// Build tree from inorder traversal
	private TreeNode listToBST(List<TreeNode> list, int start, int end) {
		if(start > end)
			return null;
		
		int mid = (start + end) / 2;
		TreeNode node = list.get(mid);
		
		node.left = listToBST(list, start, mid - 1);
		node.right = listToBST(list, mid + 1, end);
		return node;
	}
}
