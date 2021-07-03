package greedy;

public class MaximumSumEqualInThreeStacks {

//	Find the sum of all elements of in individual stacks.
//	If the sum of all three stacks is the same, then this is the maximum sum.
//	Else remove the top element of the stack having the maximum sum among three of stacks
	
	private static int maxSum(int[] stack1, int[] stack2, int[] stack3, int n1, int n2, int n3) {
		
		int result = 0;
	
		int sum1 = 0, sum2 = 0, sum3 = 0;
		for(int val : stack1)
			sum1 += val;
		for(int val : stack2)
			sum2 += val;
		for(int val : stack3)
			sum3 += val;
		
		int top1 = 0, top2 = 0, top3= 0;
		while(true) {
			
			// if stack is empty
			if(top1 == n1 || top2 == n2 || top3 == n3) {
				break;
			}
			
			// if sum of all three stacks is equal
			if(sum1 == sum2 && sum2 == sum3) {
				result = sum1;
				break;
			}
			
			// remove top element of maximum sum stack
			if(sum1 >= sum2 && sum1 >= sum3)
				sum1 -= stack1[top1++];
			else if (sum2 >= sum1 && sum2 >= sum3)
				sum2 -= stack2[top2++];
			else if(sum3 >= sum1 && sum3 >= sum2)
				sum3 -= stack3[top3++];
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
//		First element is the top of the stack		
		int stack1[] = { 3, 2, 1, 1, 1 };
        int stack2[] = { 4, 3, 2 };
        int stack3[] = { 1, 1, 4, 1 };
        
        int n1 = stack1.length;
        int n2 = stack2.length;
        int n3 = stack3.length;
        
        System.out.println(maxSum(stack1, stack2, stack3, n1, n2, n3));
	}
}
