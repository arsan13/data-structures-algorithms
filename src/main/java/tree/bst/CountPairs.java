package tree.bst;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Given two BSTs, return the count of all pairs from both the BSTs whose sum is equal to x.
public class CountPairs {

	public int countPairs1(Node root1, Node root2, int x) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		int count = 0;

		inorder(root1, list1);
		inorder(root2, list2);

		// Find pairs from two sorted arrays

		// TWO POINTER ALG. BINARY SEARCH can also be used
		int i = 0;
		int j = list2.size() - 1;
		while (i < list1.size() && j >= 0) {
			int a = list1.get(i);
			int b = list2.get(j);

			if (a + b == x) {
				count++;
				j--;
			} else if (a + b < x) {
				i++;
			} else {
				j--;
			}
		}

		return count;
	}

	public int countPairs2(Node root1, Node root2, int x) {
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		int count = 0;

		inorder(root1, set1);
		inorder(root2, set2);

		for (int i : set1) {
			if (set2.contains(x - i))
				count++;
		}

		return count;
	}

	void inorder(Node root, Collection<Integer> list) {
		if (root == null)
			return;

		inorder(root.left, list);
		list.add(root.data);
		inorder(root.right, list);
	}
}
