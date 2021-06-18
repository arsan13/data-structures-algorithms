package tree;

public class RedBlackTree {
	
	enum Color {RED, BLACK}
	
	class Node {
		int data;
		Node parent,left,right; 
		Color color;
		
		Node(int data)
		{
			this.data = data;
			parent = left = right = null;
			color = Color.RED;
		}
	}
	
	Node root;
	
	Node getParent(Node node)
	{
		return node == null ? null : node.parent; 
	}
	
	Node getGrandParent(Node node)
	{
		return getParent(getParent(node)); 
	}
	
	Node getSibling(Node node)
	{
		Node p = getParent(node);
		
		if(p == null)
			return null;
		
		if(node == p.left)
			return p.right;
		else
			return p.left;
	}
	
	Node getUncle(Node node)
	{
		Node p = getParent(node);
	
		return getSibling(p); 
	}
	
	private void rightRotate(Node node)
	{
		Node newNode = node.left;
		Node p = getParent(node);

		if(newNode != null)
		{
			node.left = newNode.right;
			newNode.right = node;
			node.parent = newNode;
	
			if (node.left != null) {
				node.left.parent = node;
			}
		
			if (p != null) 
			{
			    if (node == p.left) {
			      p.left = newNode;
			    } else if (node == p.right) {
			      p.right = newNode;
			    }
			}
			newNode.parent = p;
		}
	}
	
	private void leftRotate(Node node)
	{
		Node newNode = node.right;
		Node p = getParent(newNode);

		if(newNode != null)
		{
			node .right = newNode.left;
			newNode.left = node;
			node.parent = newNode;
			
			if(node.right != null)
				node.right.parent = node;
			
			if(p != null)
			{
				if(node == p.left)
					p.left = newNode;
				else if (node == p.right)
					p.right = newNode;
			}
			newNode.parent = p;
		}
	}
	
	Node insert(int data)
	{
		Node node = new Node(data);
		
		insertRec(root, node);
		
		insertRepairTree(node);
		
		root = node;
		while(getParent(root) != null)
			root = getParent(root);
		
		return root;
	}
	
	void insertRec(Node root, Node node)
	{
		if(root != null)
		{
			if(node.data < root.data)
			{
				if(root.left != null) {
					insertRec(root.left, node);
					return;
				}
				else {
					root.left = node;
				}
			
			}
			
			else
			{
				if(root.right != null) {
					insertRec(root.right, node);
					return;
				}
				else {
					root.right = node;
				}	
			}
		}
		
		node.parent = root;
		node.left = node.right = null;
		node.color = Color.RED;
	}
	
	void insertRepairTree(Node node)
	{
		if(getParent(node) == null)
			node.color = Color.BLACK;
		
		else if(getParent(node).color == Color.BLACK)
			return;
		
		else if(getUncle(node) != null && getUncle(node).color == Color.RED)
		{
			getParent(node).color = Color.BLACK;
			getUncle(node).color = Color.BLACK;
			getGrandParent(node).color = Color.RED;
			
			insertRepairTree(getGrandParent(node));
		}
		
		else
		{
			Node p = getParent(node);
			Node g = getGrandParent(node);
			
			if(node == p.right && p == g.left) {
				leftRotate(p);
				node = node.left;
			}
			else if (node == p.left && p == g.right){
				rightRotate(p);
				node = node.right;
			}
			
			p = getParent(node);
			g = getGrandParent(node);
			
			if(node == p.left)
				rightRotate(g);
			else
				leftRotate(g);
			
			p.color = Color.BLACK;
			g.color = Color.RED;
		}
	}
	
	public void replaceNode(Node node, Node child){

        child.parent = node.parent;
        if(node == node.parent.left){
            node.parent.left = child;
        }
        else
            node.parent.right = child;
    }

	
	public void deleteOneChild(int data){
        Node node = new Node(data);
        Node child = (node.right == null) ? node.left : node.right;
        if(child != null){
            replaceNode(node, child);
            if(node.color == Color.BLACK){
                if(child.color == Color.RED)
                    child.color = Color.BLACK;
                else
                    deleteCase1(child);
            }

        }
        //node = null;
       //free(node);
    }

    public void deleteCase1(Node node){
        if(node.parent != null) {
            Node sib = getSibling(node);
            deleteCase2(node);
        }
    }

    public void deleteCase2(Node node){
            Node sib = getSibling(node);
            if(sib.color == Color.RED){
                node.parent.color = Color.RED;
                sib.color = Color.BLACK;
                if(node == node.parent.left)
                    leftRotate(node.parent);
                else
                    rightRotate(node.parent);
            }
            deleteCase3(node);

        }
    public void deleteCase3(Node node){
        Node sib = getSibling(node);
        if((node.parent.color == Color.BLACK) && (sib.color == Color.BLACK)&&(sib.left.color == Color.BLACK) && (sib.right.color == Color.BLACK)){
            sib.color = Color.RED;
            deleteCase1(node.parent);
        }
        else{
            deleteCase4(node);
        }
    }

    public void deleteCase4(Node node){
        Node sib = getSibling(node);

        if((node.parent.color == Color.RED) && (sib.color == Color.BLACK) && (sib.left.color == Color.BLACK) && (sib.right.color == Color.BLACK)){
            sib.color = Color.RED;
            node.parent.color = Color.BLACK;
        }
        else
            deleteCase5(node);
    }

    public void deleteCase5(Node node){
        Node sib = getSibling(node);

        if(sib.color == Color.BLACK){
            if((node == node.parent.left) && (sib.right.color == Color.BLACK) &&(sib.left.color == Color.RED)){
                sib.color = Color.RED;
                sib.left.color = Color.BLACK;
                rightRotate(sib);
            }
            else if((node == node.parent.right) && (sib.left.color == Color.BLACK) &&(sib.right.color == Color.RED)){
                sib.color = Color.RED;
                sib.right.color = Color.BLACK;
                leftRotate(sib);
            }
        }
        deleteCase6(node);
    }

    public void deleteCase6(Node node){
        Node sib = getSibling(node);
        sib.color = node.parent.color;
        node.parent.color = Color.BLACK;

        if(node == node.parent.left){
            sib.right.color = Color.BLACK;
            leftRotate(node.parent);
        }
        else{
            sib.left.color = Color.BLACK;
            rightRotate(node.parent);
        }
    }
	
	void treeStructure(Node root, String indent, boolean last) 
	{   
		if (root != null) {
		   System.out.print(indent);
		   if (last) {
		      System.out.print("R----");
		      indent += "     ";
		   } else {
		      System.out.print("L----");
		      indent += "|    ";
		   }
            
		   System.out.println(root.data + "(" + root.color + ")");
		   treeStructure(root.left, indent, false);
		   treeStructure(root.right, indent, true);
		}
	}

}


/* Output

1 - Insert
2 - Display
3 - Search
4  -Delete
5 - Exit
Enter your Choice: 
1
Enter the data to be inserted: 20
20 inserted

R----20(BLACK)

1 - Insert
2 - Display
3 - Search
4  -Delete
5 - Exit
Enter your Choice: 
1
Enter the data to be inserted: 10
10 inserted

R----20(BLACK)
     L----10(RED)

1 - Insert
2 - Display
3 - Search
4  -Delete
5 - Exit
Enter your Choice: 
1
Enter the data to be inserted: 30
30 inserted

R----20(BLACK)
     L----10(RED)
     R----30(RED)

1 - Insert
2 - Display
3 - Search
4  -Delete
5 - Exit
Enter your Choice: 
1
Enter the data to be inserted: 15
15 inserted

R----20(BLACK)
     L----10(BLACK)
     |    R----15(RED)
     R----30(BLACK)

1 - Insert
2 - Display
3 - Search
4  -Delete
5 - Exit
Enter your Choice: 
1
Enter the data to be inserted: 25
25 inserted

R----20(BLACK)
     L----10(BLACK)
     |    R----15(RED)
     R----30(BLACK)
          L----25(RED)

1 - Insert
2 - Display
3 - Search
4  -Delete
5 - Exit
Enter your Choice: 
1
Enter the data to be inserted: 5
5 inserted

R----20(BLACK)
     L----10(BLACK)
     |    L----5(RED)
     |    R----15(RED)
     R----30(BLACK)
          L----25(RED)

1 - Insert
2 - Display
3 - Search
4  -Delete
5 - Exit
Enter your Choice: 
1
Enter the data to be inserted: 8
8 inserted

R----20(BLACK)
     L----10(RED)
     |    L----5(BLACK)
     |    |    R----8(RED)
     |    R----15(BLACK)
     R----30(BLACK)
          L----25(RED)

1 - Insert
2 - Display
3 - Search
4  -Delete
5 - Exit
Enter your Choice: 
1
Enter the data to be inserted: 35
35 inserted

R----20(BLACK)
     L----10(RED)
     |    L----5(BLACK)
     |    |    R----8(RED)
     |    R----15(BLACK)
     R----30(BLACK)
          L----25(RED)
          R----35(RED)

1 - Insert
2 - Display
3 - Search
4  -Delete
5 - Exit
Enter your Choice: 
2
R----20(BLACK)
     L----10(RED)
     |    L----5(BLACK)
     |    |    R----8(RED)
     |    R----15(BLACK)
     R----30(BLACK)
          L----25(RED)
          R----35(RED)

1 - Insert
2 - Display
3 - Search
4  -Delete
5 - Exit
Enter your Choice: 
1
Enter the data to be inserted: 40
40 inserted

R----20(BLACK)
     L----10(RED)
     |    L----5(BLACK)
     |    |    R----8(RED)
     |    R----15(BLACK)
     R----30(RED)
          L----25(BLACK)
          R----35(BLACK)
               R----40(RED)

1 - Insert
2 - Display
3 - Search
4  -Delete
5 - Exit
Enter your Choice: 
5

Thank you


*/