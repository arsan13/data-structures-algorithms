package tree.implementation;

import java.util.Scanner;

class MinHeap 
{
	int[] heapArr;
	int pos, capacity;
	
	MinHeap(int capacity)
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
	
		while( (heapArr[parent] > heapArr[child]) && parent > 0) 
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
        minHeapify(1); 
        return del;	
	}
	
	private void minHeapify(int pos)
	{
		if(isLeaf(pos))
			return;
		
		if( (heapArr[pos] > heapArr[leftChild(pos)]) || 
				(heapArr[pos] > heapArr[rightChild(pos)]) )
		{
			if( heapArr[leftChild(pos)] < heapArr[rightChild(pos)]) { 
                swap(pos, leftChild(pos)); 
                minHeapify(leftChild(pos)); 
            } 
            else { 
                swap(pos, rightChild(pos)); 
                minHeapify(rightChild(pos)); 
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

public class MainMinHeap
{
	public static void main(String args[])
	{
		MinHeap obj = new MinHeap(10);
		
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

/* Ouptut

1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice: 
1
Enter the data to be inserted: 50
50 inserted

1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice: 
1
Enter the data to be inserted: 10
10 inserted

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
Enter the data to be inserted: 60
60 inserted

1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice: 
1
Enter the data to be inserted: 25
25 inserted

1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice: 
2
PARENT : 10 LEFT CHILD : 25 RIGHT CHILD :40
PARENT : 25 LEFT CHILD : 60 RIGHT CHILD :50
1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice: 
1
Enter the data to be inserted: 5
5 inserted

1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice: 
2
PARENT : 5 LEFT CHILD : 25 RIGHT CHILD :10
PARENT : 25 LEFT CHILD : 60 RIGHT CHILD :50
PARENT : 10 LEFT CHILD : 40 RIGHT CHILD :0
1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice: 
3
5 deleted
1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice: 
2
PARENT : 10 LEFT CHILD : 25 RIGHT CHILD :0
PARENT : 25 LEFT CHILD : 60 RIGHT CHILD :50
1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice: 
4

Thank you


*/