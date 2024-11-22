class Solution {
    public int reversePairs(int[] nums) {
        sol(nums);
        return count;
    }
    int count = 0;
    public void sol(int[] nums) {
        mergesort(nums,0,nums.length - 1);
    }
    public void mergesort(int[] nums,int start,int end) {
        if(start >= end) {
            return;
        }
        int mid = (start + end) >> 1;
        mergesort(nums,start,mid);
        mergesort(nums,mid + 1, end);
        merge(nums,start,mid,end);
        
    }
    public void merge(int[] nums,int start, int mid, int end) {
        int left = start;
        int right = mid + 1;
        int[] result = new int[end - start + 1];
        int index = 0;
        while(left <= mid) {
            int count1 = 0;
            while(right <= end && (long)nums[left] > (long)2*nums[right]) {
                right++;
                count1++;
            }
            count = count + (mid - left + 1)*count1;
            left++;
        }
        left = start;
        right = mid + 1;
        while(left <= mid && right <= end) {
            if(nums[left] <= nums[right]) {
                result[index++] = nums[left++];
            }
            else {
                result[index++] = nums[right++];
            }
        }
        while(left <= mid) {
            result[index++] = nums[left++];
        }
        while(right <= end){
            result[index++] = nums[right++];
        }
        index = 0;
        for(int i = start;i <= end;i++) {
            nums[i] = result[index++];
        }
    }
}
