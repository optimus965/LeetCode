class Solution {
    public int findKthNumber(int m, int n, int k) {
        int position = k;
        int min = 1;
        int max = m*n;
        int ans = 0;
        while(min <= max) {
            int mid = (min + max) >> 1;
            int places =0;
            for(int i =1;i <= m;i++) {
                int start = 1;
                int end  = n;
                int ans1 = 0;
                while(start <= end) {
                    int mid1 = (start + end) >> 1;
                    int value = i*mid1;
                    if(value <= mid) {
                        start = mid1 + 1;
                        ans1 = mid1;
                    }
                    else {
                        end = mid1 - 1;
                    }
                }
                 places = places + ans1;
                
            }
            if(places < position) {
                min=  mid + 1;
               
            }
            else {
                max = mid - 1;
                ans = mid;
            }
        }
        return min;
    }
}
