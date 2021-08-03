package greedy.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class HuffmanEncoding {

	static class Node implements Comparable<Node> {
		char ch;
		int freq;
		Node left;
		Node right;

		public Node(char ch, int freq) {
			this.ch = ch;
			this.freq = freq;
		}

		@Override
		public int compareTo(Node o) {
			return this.freq - o.freq; // min-heap
		}
		
	}

	private static List<String> huffmanCodes(char[] charArray, int[] charFreq, int n) {

		List<String> res = new ArrayList<>();
		PriorityQueue<Node> pq = new PriorityQueue<>();

		for (int i = 0; i < n; i++)
			pq.add(new Node(charArray[i], charFreq[i]));

		Node root = buildHuffmanTree(pq);

		storeCode(root, "", res);

		return res;
	}

	private static Node buildHuffmanTree(PriorityQueue<Node> pq) {
		Node root = null;

		while (pq.size() > 1) {
			Node left = pq.poll(); // first minimum
			Node right = pq.poll(); // second minimum

			root = new Node('$', left.freq + right.freq);
			root.left = left;
			root.right = right;

			pq.add(root);
		}

		return root;
	}

	private static void storeCode(Node root, String str, List<String> res) {

//		store if leaf node
		if (root.left == null && root.right == null && Character.isLetter(root.ch)) {
			res.add(root.ch + ": " + str);
			return;
		}

		storeCode(root.left, str + "0", res);
		storeCode(root.right, str + "1", res);
	}

	public static void main(String[] args) {

		int n = 6;
		char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
		int[] charFreq = { 5, 9, 12, 13, 16, 45 };

		List<String> list = huffmanCodes(charArray, charFreq, n);
		System.out.println(list);
	}
}
