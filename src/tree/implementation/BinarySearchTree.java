package tree.implementation;

import java.util.Deque;
import java.util.LinkedList;

class Node {
	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
		left = right = null;
	}
}

class BstOperations {
	Node root;

	public int height(Node root) {

		if (root == null)
			return -1;

		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}

	public void insert(int data) {
		this.root = insertRec(this.root, data);
	}

	private Node insertRec(Node root, int data) {
		if (root == null) {
			Node newNode = new Node(data);
			return newNode;
		}

		if (data < root.data)
			root.left = insertRec(root.left, data);
		else if (data > root.data)
			root.right = insertRec(root.right, data);

		return root;
	}

	public boolean search(int data) {
		Node temp = root;
		while (temp != null) {
			if (temp.data > data)
				temp = temp.left;
			else if (temp.data < data)
				temp = temp.right;
			else if (temp.data == data)
				return true;
		}
		return false;
	}

	public void delete(int data) {
		if (search(data)) {
			root = deleteRec(root, data);
			System.out.println("\n" + data + " deleted");
		} else
			System.out.println("\n" + data + " not found for deletion.");
	}

	private Node deleteRec(Node root, int data) {
		if (root == null)
			return root;

		if (root.data > data)
			root.left = deleteRec(root.left, data);

		else if (root.data < data)
			root.right = deleteRec(root.right, data);

		else {
			if (root.left == null && root.right == null)
				return null;
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			root.data = minNode(root.right);

			root.right = deleteRec(root.right, root.data);
		}

		return root;
	}

	public int minNode(Node root) {
		if (root.left == null)
			return root.data;

		return minNode(root.left);
	}

	public int maxNode(Node root) {
		if (root.right == null)
			return root.data;

		return maxNode(root.right);
	}

	public void preOrder(Node root) {
		if (root == null)
			return;

		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public void inOrder(Node root) {
		if (root == null)
			return;

		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	public void postOrder(Node root) {
		if (root == null)
			return;

		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}
	
	public void levelOrder(Node root) {
		if (root == null)
			return;

		Deque<Node> queue = new LinkedList<>();
		queue.add(root);

		while (queue.size() > 0) {
			Node temp = queue.removeFirst();
			System.out.print(temp.data + " ");
			if (temp.left != null)
				queue.addLast(temp.left);
			if (temp.right != null)
				queue.addLast(temp.right);
		}
	}

	public void treeStructure(Node root, String indent, boolean last) {
		if (root != null) {
			System.out.print(indent);
			if (last) {
				System.out.print("R----");
				indent += "  ";
			} else {
				System.out.print("L----");
				indent += "|  ";
			}
			System.out.println(root.data);
			treeStructure(root.left, indent, false);
			treeStructure(root.right, indent, true);
		}
	}

}

public class BinarySearchTree {

	public static void main(String[] args) {

		BstOperations bst = new BstOperations();

		bst.insert(30);
		bst.insert(40);
		bst.insert(20);
		bst.insert(10);
		bst.insert(25);

		int height = bst.height(bst.root);
		System.out.print("\nHeight of the tree : " + height);

		System.out.print("\nInorder Traversal : ");
		bst.inOrder(bst.root);

		System.out.print("\nPre-oder Traversal : ");
		bst.preOrder(bst.root);

		System.out.print("\nPost-order Traversal : ");
		bst.postOrder(bst.root);

		System.out.print("\nLevel-order Traversal : ");
		bst.levelOrder(bst.root);

		System.out.println("\n");
		bst.treeStructure(bst.root, "", true);

		int find = 20;
		if (bst.search(find))
			System.out.println("\nSearch: " + find + " Found");
		else
			System.out.println("\nSearch: " + find + " Not Found");

		int min = bst.minNode(bst.root);
		int max = bst.maxNode(bst.root);
		System.out.println("\nMinimum = " + min);
		System.out.println("Maximum = " + max);

		bst.delete(20);

		System.out.print("\nInorder Traversal : ");
		bst.inOrder(bst.root);

		System.out.print("\nPre-oder Traversal : ");
		bst.preOrder(bst.root);

		System.out.print("\nPost-order Traversal : ");
		bst.postOrder(bst.root);

		System.out.println("\n");
		bst.treeStructure(bst.root, "", true);
	}

}
