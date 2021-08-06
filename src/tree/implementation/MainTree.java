package tree.implementation;

import java.util.Scanner;

public class MainTree 
{
	public static void main(String[] args) 
	{	
		RBTree obj = new RBTree();
		
		Scanner input = new Scanner(System.in);
		
		boolean op = true;
		while(op) 
		{	
			System.out.println("1 - Insert\n2 - Display\n3  -Search\n4  -Delete\n5 - Exit");   
            System.out.print("Enter your Choice: \n");
            int choice = input.nextInt();
            int data;
            
            switch(choice)
            {
            case 1:  
                System.out.print("Enter the data to be inserted: ");
                data = input.nextInt();
                obj.insert(data);
                System.out.println(data + " inserted\n");
            
            case 2:
            	if(obj.root == null)
            		System.out.println("Tree is Empty");
            	else 
            		obj.treeStructure(obj.root, "", true);
            	System.out.println();
            	break;
            
            case 3: 
                System.out.print("Enter the data to be searched: ");
                data = input.nextInt();
                System.out.println(obj.search(data));
                break;
            	
            case 4: 
                System.out.print("Enter the data to be deleted: ");
                data = input.nextInt();
                obj.delete(data);
                break;
            	
            case 5: 
                System.out.println("\nThank you");
                op = false;
                break;
            
            default:
            	System.out.println("\nInvalid Choice");
            	break;
            }
        }				
		input.close();
	}
}

