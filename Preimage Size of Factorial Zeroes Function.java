class Solution {
    public int preimageSizeFZF(int k1) {
        long k = k1;
        long min = 0;
        long max = k*5;
        while(min <= max) {
            long mid = (min + max)>>1;
            long count = 0;
            long value = 5;
            while(true) {
                count = count + mid/value;
                value = value*5;
                if(value > mid) {
                    break;
                }
            }
            if(count == k) {
                return 5;
            }
            if(count < k) {
                min = mid + 1;
            }
            else {
                max = mid - 1;
            }
        }
        return 0;
    }
}
