package tree.bt;

//Given a Binary Tree, check if all leaves are at same level or not.
public class LevelOfLeafNodes {
	int leafLevel = 0;

	boolean check(Node root) {
		int level = 0;
		return check(root, level);
	}

	boolean check(Node root, int level) {
		if (root == null)
			return true;

		if (root.left == null && root.right == null) {
			if (leafLevel == 0) {
				leafLevel = level;
				return true;
			}
			return leafLevel == level;
		}

		return check(root.left, level + 1) && check(root.right, level + 1);
	}
}
