class Solution {
    public int largestRectangleArea(int[] heights) {
        int max =0;
        Stack<Integer> stack = new Stack<>();
        int[] nums = new int[heights.length];
        stack.push(-1);
        for(int i =0;i < heights.length;i++) {
            while(stack.size() > 0 && stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            nums[i] = stack.isEmpty() ? heights[i]:(i - stack.peek())*heights[i];
            stack.push(i);
        }
        int[] nums1 =new int[heights.length];
        stack = new Stack<>();
        stack.push(heights.length);
        for(int i = heights.length - 1;i >= 0;i--) {
            while(stack.size() > 0 && stack.peek() != heights.length &&  heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            nums1[i] = stack.isEmpty() ? heights[i]:(stack.peek() - i)*heights[i];
            stack.push(i);
        }
        for(int i =0;i < heights.length;i++) {
            max = Math.max(max,nums[i] + nums1[i] - heights[i]);
        }
        return max;
    }
}
