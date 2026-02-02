package tree.bt;

import java.util.HashMap;
import java.util.Map;


//Construct Tree from Inorder & Preorder
class ConstructTree1 {
	private Map<Integer, Integer> map;
	private int preIndex;

	public Node buildTree(int inorder[], int preorder[], int n) {
		map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}

		preIndex = 0;
		return buildTree(preorder, 0, n - 1);
	}

	private Node buildTree(int preorder[], int inStart, int inEnd) {
		if (inStart > inEnd)
			return null;

		// Pick current node from preorder traversal using preIndex
		Node node = new Node(preorder[preIndex]);
		preIndex++;

		if (inStart == inEnd)
			return node;

		// Else get the index of this node in Inorder traversal
		int inIndex = map.get(node.data);

		// Using index in inorder traversal, construct left and right subtrees
		node.left = buildTree(preorder, inStart, inIndex - 1);
		node.right = buildTree(preorder, inIndex + 1, inEnd);

		return node;
	}
}


//Construct tree from Inorder and Postorder 
class ConstructTree2 {
	private Map<Integer, Integer> map;
    private int postIndex;
    
    public Node buildTree(int inorder[], int postorder[], int n)
    {
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        postIndex = n-1;
        return buildTree(postorder, 0, n-1);
    }
    
    private Node buildTree(int postorder[], int inStart, int inEnd)
    {
        if(inStart > inEnd)
            return null;
        
        // Pick current node from postorder traversal using postIndex
        Node node = new Node(postorder[postIndex]);
        postIndex--;
        
        if(inStart == inEnd)
            return node;
        
        // Else get the index of this node in Inorder traversal
        int inIndex = map.get(node.data);
        
        // Using index in inorder traversal, construct left and right subtrees        
        node.right = buildTree(postorder, inIndex+1, inEnd);
        node.left = buildTree(postorder, inStart, inIndex-1);
        
        return node;
    }
}


//Construct tree from Inorder and LevelOrder 
class ConstructTree3 {
	private Map<Integer, Integer> map;

	public Node buildTree(int inorder[], int level[]) {
		map = new HashMap<>();
		for (int i = 0; i < level.length; i++) {
			map.put(level[i], i);
		}

		return buildTree(inorder, 0, inorder.length - 1);
	}

	private Node buildTree(int inorder[], int inStart, int inEnd) {
		if (inStart > inEnd)
			return null;

		// find node with minimum index in level-order traversal
		// That would be the root node of inorder[start, end]
		int inIndex = inStart;
		for (int i = inStart + 1; i <= inEnd; i++) {
			if (map.get(inorder[i]) < map.get(inorder[inIndex]))
				inIndex = i;
		}

		Node node = new Node(inorder[inIndex]);

		if (inStart == inEnd)
			return node;

		node.left = buildTree(inorder, inStart, inIndex - 1);
		node.right = buildTree(inorder, inIndex + 1, inEnd);

		return node;
	}

}