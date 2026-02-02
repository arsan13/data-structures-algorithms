package greedy.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class HuffmanEncodingAndDecoding {

	PriorityQueue<Node> pq = new PriorityQueue<>();
	Node root = null;
	
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

	private String encode(char[] charArray, int[] charFreq, int n) {

		List<String> res = new ArrayList<>();

		for (int i = 0; i < n; i++)
			pq.add(new Node(charArray[i], charFreq[i]));

		Node root = buildHuffmanTree(pq);
		
		storeCode(root, "", res);

		String str = "";
		for(String s : res)
			str += s;
		
		return str;
	}

	private  Node buildHuffmanTree(PriorityQueue<Node> pq) {

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

	private void storeCode(Node root, String str, List<String> res) {

		if (root.left == null && root.right == null && Character.isLetter(root.ch)) {
			res.add(str);
			return;
		}

		storeCode(root.left, str + "0", res);
		storeCode(root.right, str + "1", res);
	}

	public String decode(String str) {
		Node temp = root;
		StringBuilder res = new StringBuilder();
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1') 
				temp = temp.right;
			else 
				temp = temp.left;
			
			if (temp.left == null && temp.right == null) {
				res.append(temp.ch);
				temp = root;
			}
		}		
		return res.toString();
	}
	
	public static void main(String[] args) {

		int n = 6;
		char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
		int[] charFreq = { 5, 9, 12, 13, 16, 45 };

		HuffmanEncodingAndDecoding obj = new HuffmanEncodingAndDecoding();
		
		String encode = obj.encode(charArray, charFreq, n);
		System.out.println(encode);
		
		String decode = obj.decode(encode);
		System.out.println(decode);
	}
}
