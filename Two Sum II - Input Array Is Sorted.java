class solution {
	public int[] sol(int[] nums, int target)  {
		int lower = 0;
		int[] n =new int[2];
		int higher  = nums.length - 1;
		while(lower < higher) {
			if(nums[lower] + nums[higher] == target) {
				n[0] = lower + 1;
				n[1] = higher + 1;
				break;
			}
			else if(nums[lower] + nums[higher] > target) {
				higher--;
			}
			else if(nums[lower]  + nums[higher] < target) {
				lower++;
			}
		}
		return n;
			
	}
 
}