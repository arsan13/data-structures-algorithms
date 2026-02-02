package dp.group3;

// Same as HouseRobber1, but all houses are arranged in a circle.
public class HouseRobber2 {
	
	private static int rob(int[] nums) {
        int n = nums.length;
        
        if(n == 1)
            return nums[0];
        if(n == 2)
            return Math.max(nums[0], nums[1]);
        
        int rob1 = robUtil(nums, 0, n - 2);
        int rob2 = robUtil(nums, 1, n - 1);
        
        return Math.max(rob1, rob2);
    }
    
    private static int robUtil(int[] arr, int start, int end) {
		int oldInc = arr[start];
		int oldExc = 0;
		
		for(int i = start + 1; i <= end; i++) {
			int newInc = arr[i] + oldExc;
			int newExc = Math.max(oldInc, oldExc);
			
			oldInc = newInc;
			oldExc = newExc;
		}
		
		return Math.max(oldInc, oldExc);
    }
	
	public static void main(String[] args) {
		
		int[] arr = {2,3,2};
		System.out.println(rob(arr));
	}
}
