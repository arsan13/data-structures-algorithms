package tree.implementation;

public class AvlTree
{	
	class Node
	{
		int data;
		Node left, right;
		int height;
		
		Node(int data)
		{
			this.data = data;
			left = right = null;
			this.height = 1; 
		}
	}
	
	Node root;
	
	public int height(Node root)
	{
		if(root == null)
			return 0;
		
		return root.height;
	}
	
	private int getBalance(Node root)
	{
		if(root == null)
			return 0;
		
		return height(root.left) - height(root.right);
	}
	
	public void insert(int data)
	{
		this.root = insertRec(this.root, data);
	}
	
	private Node insertRec(Node root, int data)
	{	
		if(root == null){
			Node newNode = new Node(data);
			return newNode;
		}
		
		if(data < root.data)
			root.left = insertRec(root.left, data);
		else if(data > root.data)
			root.right = insertRec(root.right, data);
		
		root.height = 1 + Math.max(height(root.left), height(root.right));
		int bal = getBalance(root);
		
		//LL
		if(bal > 1 && data < root.left.data){
			System.out.println("LL Rotation");
			return rightRotate(root);
		}
		
		//RR
		if(bal < -1 && data > root.right.data) {
			System.out.println("RR Rotation");
			return leftRotate(root);
		}
			
		//LR
		if(bal > 1 && data > root.left.data) {
			System.out.println("LR Rotation");
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}
		
		//RL
		if(bal < -1 && data < root.right.data) {
			System.out.println("RL Rotation");
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}
			
		return root;
	}
	
	public boolean search(int data)
	{
		Node temp = root;
		while(temp != null)
		{
			if(temp.data > data)
				temp = temp.left;
			else if(temp.data < data)
				temp = temp.right;
			else if(temp.data == data)
				return true;
		}
		return false;
	}
	
	public void delete(int data)
	{
		if(search(data)) 
		{
			root = deleteRec(root, data);
			System.out.println(data + " deleted\n");
		}
		else
			System.out.println(data + " not found for deletion.\n");
	}
	
	private Node deleteRec(Node root, int data)
	{
		if(root == null)
			return root;
		
		if(root.data > data)
			root.left = deleteRec(root.left, data);
		
		else if(root.data < data)
			root.right = deleteRec(root.right, data);
		
		else
		{
			if(root.left == null && root.right == null)
				return null;
			if(root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			
			root.data = minNode(root.right);
			
			root.right = deleteRec(root.right, root.data);
		}
		
		root.height = 1 + Math.max(height(root.left), height(root.right));		
        int bal = getBalance(root);  
  
        //LL 
        if(bal > 1 && getBalance(root.left) >= 0) {
        	System.out.println("LL Rotation");
        	return rightRotate(root);
        }
        
		//RR
		if(bal < -1 && getBalance(root.right) < 0) {
			System.out.println("RR Rotation");
			return leftRotate(root);
		}
		
		//LR
		if(bal > 1 && getBalance(root.left) < 0) {
			System.out.println("LR Rotation");
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}
		
		//RL
		if(bal < -1 && getBalance(root.right) > 0) {
			System.out.println("RL Rotation");
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}	
		
		return root;
	}
	
	public int minNode(Node root)
	{
		if(root.left == null)
			return root.data;
		
		return minNode(root.left);
	}
	
	private Node rightRotate(Node y)
	{
		Node x = y.left;
		Node T3 = x.right;
		
		//Rotate
		x.right = y;
		y.left = T3;
		
		//Update Height
		y.height = Math.max(height(y.left), height(y.right)) + 1;
		x.height = Math.max(height(x.left), height(x.right)) + 1;
	
		return x;
	}
	
	private Node leftRotate(Node x)
	{
		Node y = x.right;
		Node T3 = y.left;
		
		//Rotate
		y.left = x;
		x.right = T3;
		
		//Update Height
		x.height = Math.max(height(x.left), height(x.right)) + 1;
		y.height = Math.max(height(y.left), height(y.right)) + 1;
	
		return y;
	}
	
	public void treeStructure(Node root, String indent, boolean last)
	{
		if(root != null)
		{	
			System.out.print(indent);
			if(last) {
				System.out.print("R----");
				indent += "  ";
			}
			else {
				System.out.print("L----");
				indent += "|  ";
			}
			System.out.println(root.data);
			treeStructure(root.left, indent, false);
			treeStructure(root.right, indent, true);
		}		
	}
	
}


/* Output

1 - Insert
2 - Delete
3 - Find
4  -Display
5 - Exit
Enter your Choice: 
1
Enter a Key to be inserted: 10

1 - Insert
2 - Delete
3 - Find
4  -Display
5 - Exit
Enter your Choice: 
1
Enter a Key to be inserted: 20

1 - Insert
2 - Delete
3 - Find
4  -Display
5 - Exit
Enter your Choice: 
1
Enter a Key to be inserted: 30
RR Rotation

1 - Insert
2 - Delete
3 - Find
4  -Display
5 - Exit
Enter your Choice: 
4
R----20
  L----10
  R----30

1 - Insert
2 - Delete
3 - Find
4  -Display
5 - Exit
Enter your Choice: 
1
Enter a Key to be inserted: 50

1 - Insert
2 - Delete
3 - Find
4  -Display
5 - Exit
Enter your Choice: 
1
Enter a Key to be inserted: 40
RL Rotation

1 - Insert
2 - Delete
3 - Find
4  -Display
5 - Exit
Enter your Choice: 
4
R----20
  L----10
  R----40
    L----30
    R----50

1 - Insert
2 - Delete
3 - Find
4  -Display
5 - Exit
Enter your Choice: 
2
Enter a Key to be deleted: 10

10 deleted


1 - Insert
2 - Delete
3 - Find
4  -Display
5 - Exit
Enter your Choice: 
4
R----20
  R----40
    L----30
    R----50

1 - Insert
2 - Delete
3 - Find
4  -Display
5 - Exit
Enter your Choice: 
1
Enter a Key to be inserted: 5

1 - Insert
2 - Delete
3 - Find
4  -Display
5 - Exit
Enter your Choice: 
1
Enter a Key to be inserted: 60
RR Rotation

1 - Insert
2 - Delete
3 - Find
4  -Display
5 - Exit
Enter your Choice: 
1
Enter a Key to be inserted: 15

1 - Insert
2 - Delete
3 - Find
4  -Display
5 - Exit
Enter your Choice: 
4
R----40
  L----20
  |  L----5
  |  |  R----15
  |  R----5
  |    R----15
  R----50
    R----60

1 - Insert
2 - Delete
3 - Find
4  -Display
5 - Exit
Enter your Choice: 
2
Enter a Key to be deleted: 60
LL Rotation

60 deleted


1 - Insert
2 - Delete
3 - Find
4  -Display
5 - Exit
Enter your Choice: 
4
R----20
  L----5
  |  R----15
  R----40
    L----5
    |  R----15
    R----50

1 - Insert
2 - Delete
3 - Find
4  -Display
5 - Exit
Enter your Choice: 
5
Exiting

*/