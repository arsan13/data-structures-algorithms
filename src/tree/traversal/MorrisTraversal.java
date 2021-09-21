package tree.traversal;

public class MorrisTraversal {

	// In-order traversal with O(1) Space
	public void inOrder(Node root) {
		Node curr = root;

		while (curr != null) {
			if (curr.left == null) {
				System.out.println(curr.data);
				curr = curr.right;
			}

			else {
				Node prev = curr.left;
				while (prev.right != null && prev.right != curr) {
					prev = prev.right;
				}

				if (prev.right == null) {
					prev.right = curr;
					curr = curr.left;
				} else {
					prev.right = null;
					System.out.println(curr.data);
					curr = curr.right;
				}
			}
		}
	}
	
	// Pre-order traversal with O(1) Space
	public void preOrder(Node root) {
		Node curr = root;
		
		while (curr != null) {
			if (curr.left == null) {
				System.out.println(curr.data);
				curr = curr.right;
			}
			
			else {
				Node prev = curr.left;
				while (prev.right != null && prev.right != curr) {
					prev = prev.right;
				}
				
				if (prev.right == null) {
					prev.right = curr;
					System.out.println(curr.data);
					curr = curr.left;
				} else {
					prev.right = null;
					curr = curr.right;
				}
			}
		}
	}
}
