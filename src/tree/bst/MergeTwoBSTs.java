package tree.bst;

import java.util.ArrayList;
import java.util.List;

//Given two BSTs, return list of elements of both BSTs in sorted form.
public class MergeTwoBSTs {

	public List<Integer> merge(Node root1, Node root2) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();

		inorder(root1, list1);
		inorder(root2, list2);

		return mergeLists(list1, list2);
	}

	private void inorder(Node root, List<Integer> list) {
		if (root == null)
			return;

		inorder(root.left, list);
		list.add(root.data);
		inorder(root.right, list);
	}

	private List<Integer> mergeLists(List<Integer> list1, List<Integer> list2) {
		List<Integer> result = new ArrayList<>();

		int i = 0;
		int j = 0;
		while (i < list1.size() && j < list2.size()) {
			if (list1.get(i) <= list2.get(j)) {
				result.add(list1.get(i));
				i++;
			} else {
				result.add(list2.get(j));
				j++;
			}
		}

		while (i < list1.size()) {
			result.add(list1.get(i));
			i++;
		}

		while (j < list2.size()) {
			result.add(list2.get(j));
			j++;
		}

		return result;
	}
}
