package tree.bst;

// Count number of nodes that lies in the given range.
public class CountBSTNodes {
	
	// int count;
    // int getCount(Node root,int l, int h) {
    //     count = 0;
    //     traverse(root, l, h);
    //     return count;
    // }
    
    // void traverse(Node root,int l, int h)
    // {
    //     if(root == null)
    //         return;
        
    //     if(root.data > l && root.data > h)
    //         traverse(root.left, l, h);
            
    //     else if(root.data < l && root.data < h)
    //         traverse(root.right, l, h); 
        
    //     else {
    //         traverse(root.left, l, h);
    //         count++;
    //         traverse(root.right, l, h);
    //     } 
    // }
    
    int getCount(Node root,int l, int h) {
        
        if(root == null)
            return 0;
            
        if(root.data >= l && root.data <= h)
            return 1 + getCount(root.left, l, h) + getCount(root.right, l, h);
        
        if(root.data < l)
            return getCount(root.right, l, h);
        else
            return getCount(root.left, l, h);
    }
}
