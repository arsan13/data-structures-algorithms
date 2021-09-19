package tree.bt;

import java.util.ArrayList;

public class LeftViewOfTree {
	private ArrayList<Integer> res = new ArrayList<>();
	private int maxLevel = -1;

	public ArrayList<Integer> leftView(Node root) {
		leftViewRec(root, 0);
		return res;
	}

	private void leftViewRec(Node root, int level) {
		if (root == null)
			return;

//		if (maxLevel < level) {
//			res.add(root.data);
//			maxLevel = level;
//		}
		
		if (level == res.size()) {
			res.add(root.data);
		}

		leftViewRec(root.left, level + 1);
		leftViewRec(root.right, level + 1);
	}
}
