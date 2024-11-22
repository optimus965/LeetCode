class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < nums.length;i++) {
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        Arrays.sort(nums);
        max = max - min;
        min = 0;
        int ans = 0;
        while(min <= max) {
            int mid = (min + max) >> 1;
            int count =0;
            for(int i = 0;i < nums.length;i++) {
                for(int j = i  + 1;j < nums.length;j++) {
                    if(Math.abs(nums[j] - nums[i]) <= mid) {
                        count = count + 1;
                    }
                    else {
                        break;
                    }
                }
            }
            if(count < k) {
                min = mid + 1;
            }
            else {
                max = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
}
