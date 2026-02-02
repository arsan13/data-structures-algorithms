package tree.bt;

import java.util.ArrayList;
import java.util.List;


//Given the root of a binary tree, return all root-to-leaf paths in any order.
public class BinaryTreePaths {
	public List<String> binaryTreePaths(Node root) {
		List<String> paths = new ArrayList<>();

		if (root == null)
			return paths;

		findPathsByDFS(root, "", paths);
		return paths;
	}

	void findPathsByDFS(Node root, String path, List<String> paths) {
		path += root.data;

		if (root.left == null && root.right == null) { // base condition
			paths.add(path);
			return;
		}

		if (root.left != null)
			findPathsByDFS(root.left, path + "->", paths);

		if (root.right != null)
			findPathsByDFS(root.right, path + "->", paths);
	}
}
