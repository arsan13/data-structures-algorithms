package tree.bt;

import java.util.ArrayList;
import java.util.List;

/* Given a binary tree with distinct nodes(no two nodes have the same have data values). 
 * The problem is to print the path from root to a given node value x.*/
public class RootToNodePath {

	public List<Integer> getPath(Node root, int x) {
		List<Integer> res = new ArrayList<>();

		if (root == null)
			return res;

		getPathUtil(root, x, res);

		return res;
	}

	private boolean getPathUtil(Node root, int x, List<Integer> res) {
		if (root == null)
			return false;

		res.add(root.data);

		if (root.data == x)
			return true;
		if (getPathUtil(root.left, x, res) || getPathUtil(root.right, x, res))
			return true;

		res.remove(res.size() - 1);
		return false;
	}
}
