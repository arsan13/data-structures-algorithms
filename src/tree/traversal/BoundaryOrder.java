package tree.traversal;

import java.util.ArrayList;

//Anti-clockwise direction
public class BoundaryOrder {

	public ArrayList<Integer> printBoundary1(Node node) {
		ArrayList<Integer> ans = new ArrayList<Integer>();

		if (isLeaf(node) == false)
			ans.add(node.data);

		addLeftBoundary(node, ans);
		addLeaves(node, ans);
		addRightBoundary(node, ans);

		return ans;
	}

	private Boolean isLeaf(Node root) {
		return (root.left == null) && (root.right == null);
	}

	private void addLeftBoundary(Node root, ArrayList<Integer> res) {
		Node cur = root.left;
		while (cur != null) {
			if (isLeaf(cur) == false)
				res.add(cur.data);
			if (cur.left != null)
				cur = cur.left;
			else
				cur = cur.right;
		}
	}

	private void addRightBoundary(Node root, ArrayList<Integer> res) {
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		Node cur = root.right;
		while (cur != null) {
			if (isLeaf(cur) == false)
				tmp.add(cur.data);
			if (cur.right != null)
				cur = cur.right;
			else
				cur = cur.left;
		}

		int i;
		for (i = tmp.size() - 1; i >= 0; --i) {
			res.add(tmp.get(i));
		}
	}

	private void addLeaves(Node root, ArrayList<Integer> res) {
		if (isLeaf(root)) {
			res.add(root.data);
			return;
		}
		if (root.left != null)
			addLeaves(root.left, res);
		if (root.right != null)
			addLeaves(root.right, res);
	}

	/******************* ALTERNATE METHOD *********************/
	ArrayList<Integer> res;

	ArrayList<Integer> printBoundary2(Node node) {

		res = new ArrayList<>();
		res.add(node.data);

		printLeftBoundary(node.left);
		printLeafNodes(node.left);
		printLeafNodes(node.right);
		printRightBoundary(node.right);

		return res;
	}

	private void printLeftBoundary(Node node) {

		if (node == null)
			return;

		if (node.left != null) {
			res.add(node.data);
			printLeftBoundary(node.left);
		}

		else if (node.right != null) {
			res.add(node.data);
			printLeftBoundary(node.right);
		}
	}

	private void printRightBoundary(Node node) {

		if (node == null)
			return;

		if (node.right != null) {
			printRightBoundary(node.right);
			res.add(node.data);
		}

		else if (node.left != null) {
			printRightBoundary(node.left);
			res.add(node.data);
		}
	}

	private void printLeafNodes(Node node) {

		if (node == null)
			return;

		printLeafNodes(node.left);

		if (node.left == null && node.right == null)
			res.add(node.data);

		printLeafNodes(node.right);
	}
}
