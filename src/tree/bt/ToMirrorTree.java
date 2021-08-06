package tree.bt;

public class ToMirrorTree {
	public void mirror(Node node) {
	   if(node == null)
	    return;
	    
	    mirror(node.left);
	    mirror(node.right);
	    
	    //swap
	    Node temp = node.left;
	    node.left = node.right;
	    node.right = temp;
    }
}
