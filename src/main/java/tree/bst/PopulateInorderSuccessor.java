package tree.bst;

public class PopulateInorderSuccessor {

	Node next = null;
    public void populateNext(Node root){
        
        if(root == null)
            return;
            
        // IN-ORDER
        // populateNext(root.left);
        
        // if(prev != null)
        //     prev.next = root;
        // prev = root;

        // populateNext(root.right);
        
        // REVERSE IN-ORDER
        populateNext(root.right);
        
        root.next = next;
        next = root;

        populateNext(root.left);
    }
    
    private class Node {
        int data;
        Node left, right,next;
        
        public Node(int data){
            this.data = data;
        }
    }
}	
