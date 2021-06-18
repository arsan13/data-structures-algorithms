  package tree;

import java.util.Scanner;

class MaxHeap 
{

	int[] heapArr;
	int pos, capacity;
	
	MaxHeap(int capacity)
	{
		this.capacity = capacity;
		this.pos = 0;
		heapArr = new int[this.capacity];
	}
	
	private int getParent(int pos)
	{
		return (pos / 2);
	}
	
	private int leftChild(int pos)
	{
		return (2 * pos); 
	}
	
	private int rightChild(int pos)
	{
		return (2 * pos) + 1; 
	}
	
	private boolean isLeaf(int pos)
	{
		if(pos >= capacity/2 && pos <= capacity)
			return true;
		
		return false;
	}
	
	private void swap(int pos1, int pos2)
	{
		int temp;
		temp = heapArr[pos1];
		heapArr[pos1] = heapArr[pos2];
		heapArr[pos2] = temp;
	}
	
	public void insert(int data)
	{
		heapArr[++pos] = data;
		
		int child = pos;
		int parent = getParent(child);
	
		while( (heapArr[parent] < heapArr[child]) && parent > 0) 
		{
			swap(parent, child);
			child = parent;
			parent = getParent(child);
		}
	}
	
	public int delete()
	{
		int del = heapArr[1];
		heapArr[1] = heapArr[pos--]; 
        maxHeapify(1); 
        return del;	
	}
	
	private void maxHeapify(int pos)
	{
		if(isLeaf(pos))
			return;
		
		if( (heapArr[pos] < heapArr[leftChild(pos)]) || 
				(heapArr[pos] < heapArr[rightChild(pos)]) )
		{
			if( heapArr[leftChild(pos)] > heapArr[rightChild(pos)]) { 
                swap(pos, leftChild(pos)); 
                maxHeapify(leftChild(pos)); 
            } 
            else { 
                swap(pos, rightChild(pos)); 
                maxHeapify(rightChild(pos)); 
            }
		}
	}
	
	public void print()
	{		
		for (int i = 1; i <= pos / 2; i++) { 
            System.out.print("PARENT : " + heapArr[i] + 
            		" LEFT CHILD : " + heapArr[leftChild(i)] + 
            		" RIGHT CHILD :" + heapArr[rightChild(i)]); 
            
            System.out.println(); 
        } 
	}
}

public class MainMaxHeap
{
	public static void main(String args[])
	{
		MaxHeap obj = new MaxHeap(10);
		
		Scanner input = new Scanner(System.in);
		
		boolean op = true;
		while(op) 
		{	
			System.out.println("1 - Insert\n2 - Display\n3  -Delete\n4 - Exit");   
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
                break;
            
            case 2:
            	obj.print();
            	break;
            
            case 3: 
                int del = obj.delete();
                System.out.println(del + " deleted");
                break;
            	
            case 4: 
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

/* Output

1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice: 
1
Enter the data to be inserted: 40
40 inserted

1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice: 
1
Enter the data to be inserted: 20
20 inserted

1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice: 
1
Enter the data to be inserted: 70
70 inserted

1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice: 
1
Enter the data to be inserted: 30
30 inserted

1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice: 
1
Enter the data to be inserted: 80
80 inserted

1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice: 
2
PARENT : 80 LEFT CHILD : 70 RIGHT CHILD :40
PARENT : 70 LEFT CHILD : 20 RIGHT CHILD :30
1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice: 
3
80 deleted
1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice: 
2
PARENT : 70 LEFT CHILD : 30 RIGHT CHILD :40
PARENT : 30 LEFT CHILD : 20 RIGHT CHILD :30
1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice: 
4

Thank you


*/