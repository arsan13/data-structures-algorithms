package tree.bt;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class TreeTraversals 
{	
	public void preOrder(Node root)
	{
		if(root == null)
			return;
		
		// Recursion
//		System.out.print(root.data + " ");
//		preOrder(root.left);
//		preOrder(root.right);
		
		// Iteration
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			root = stack.pop();
			System.out.print(root.data + " ");
			if(root.right != null)
				stack.push(root.right);
			if(root.left != null)
				stack.push(root.left);
		}
	}
	
	public void inOrder(Node root)
	{
		if(root == null)
			return;
		
		// Recursion
//		inOrder(root.left);
//		System.out.print(root.data + " ");
//		inOrder(root.right);
		
		// Iteration
		Stack<Node> stack = new Stack<>();
		while(root != null || !stack.isEmpty()) {
			if(root != null) {
				stack.push(root);
				root = root.left;
			}
			else {
				root = stack.pop();
				System.out.print(root.data + " ");
				root = root.right;
			}
		}
	}
	
	public void postOrder(Node root)
	{
		if(root == null)
			return;
		
		// Recursive
//		postOrder(root.left);
//		postOrder(root.right);
//		System.out.print(root.data + " ");
		
		// Iteration : Two Stacks
//		Stack<Node> stack1 = new Stack<>();
//		Stack<Node> stack2 = new Stack<>();
//		stack1.push(root);
//		
//		while(!stack1.isEmpty()) {
//			root = stack1.pop();
//			stack2.push(root);
//			if(root.left != null)
//				stack1.push(root.left);
//			if(root.right != null)
//				stack2.push(root.right);
//		}
//		
//		while(!stack2.isEmpty()) {
//			root = stack2.pop();
//			System.out.print(root.data + " ");
//		}
		
		// Iteration : Single Stack
		Stack<Node> stack = new Stack<>();
		Node current = root;
		Node prev = null;
		
		while(current != null || !stack.isEmpty()) {
			if(current != null) {
				stack.push(current);
				current = current.left;
			}
			else {
				current = stack.peek();
				if(current.right == null || current.right == prev) {
					System.out.print(current.data + " ");
					stack.pop();
					prev= current;
					current = null;
				}
				else
					current = current.right;
			}
		}
	}
	
	public void levelOrder(Node root)
	{
		if(root == null)
			return;
		
		Deque<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(queue.size() > 0) {
			Node temp = queue.removeFirst();
			System.out.print(temp.data + " ");
			if(temp.left != null)
				queue.addLast(temp.left);
			if(temp.right != null)
				queue.addLast(temp.right);
		}
	}
	
	public void reverseLevelOrder(Node root)
	{
		if(root == null)
			return;
		
		Deque<Node> queue = new LinkedList<>();
		Stack<Node> stack = new Stack<>();
		queue.add(root);
		
		while(queue.size() > 0) {
			Node node = queue.removeFirst();
			if(node.right != null)
				queue.addLast(node.right);
			if(node.left != null)
				queue.addLast(node.left);
			stack.push(node);
		}
		
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			System.out.print(node.data + " ");
		}
	}
	
	void  spiralOrder(Node root) 
    {
        if (root == null)
            return;
        
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        
        stack1.push(root);
        
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            
            while(!stack1.isEmpty()) {
                root = stack1.pop();
                System.out.print(root.data + " ");
                
                if(root.left != null) 
                    stack2.push(root.left);
                if(root.right != null) 
                    stack2.push(root.right);
            }
            
            while(!stack2.isEmpty()) {
                root = stack2.pop();
                System.out.print(root.data + " ");
                
                if(root.right != null) 
                    stack1.push(root.right);
                if(root.left != null) 
                    stack1.push(root.left);
            }
        }
    }
	
	public void printBoundary(Node node) {
    
		System.out.print(node.data + " ");
    
	    printLeftBoundary(node.left);
	    printLeafNodes(node.left);
	    printLeafNodes(node.right);
	    printRightBoundary(node.right);
    
	}
	
	private void boundaryOrder(Node node) {
	    
	    if(node == null)
	        return;
	    
	    if(node.left != null){
	    	System.out.print(node.data + " ");
	        printLeftBoundary(node.left);
	    }
	    
	    else if(node.right != null){
	    	System.out.print(node.data + " ");
	        printLeftBoundary(node.right);
	    }
	}
	
	private void printLeftBoundary(Node node) {
	    
	    if(node == null)
	        return;
	    
	    if(node.left != null){
	        printLeftBoundary(node.left);
	        System.out.print(node.data + " ");
	    }
	    
	    else if(node.right != null){
	        printLeftBoundary(node.right);
	        System.out.print(node.data + " ");
	    }
	}
	
	private void printRightBoundary(Node node) {
	    
	    if(node == null)
	        return;
	    
	    if(node.right != null){
	        printRightBoundary(node.right);
	        System.out.print(node.data + " ");
	    }
	    
	    else if(node.left != null){
	        printRightBoundary(node.left);
	        System.out.print(node.data + " ");
	    }
	}
	
	private void printLeafNodes(Node node) {
	    
	    if(node == null)
	        return;
	    
	    printLeafNodes(node.left);
	    
	    if(node.left == null && node.right == null)
	    	System.out.print(node.data + " ");
	        
	    printLeafNodes(node.right);
	}
}
