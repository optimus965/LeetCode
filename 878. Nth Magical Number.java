class Solution {
    static long GCD(long u, long v)
    {
        if (u == 0)
            return v;
        return GCD(v % u, u);
    }
    static long LCM(long u, long v)
    {
        return (u / GCD(u, v)) * v;
    }
    public int nthMagicalNumber(int n1, int a1, int b1) {
        long n = n1;
        long a = a1;
        long b = b1;
        long min = Math.min(a,b);
        long max = Math.max(a,b)*n;
        long number = LCM(a,b);
        long  ans = 0;
        while(min <= max) {
            long mid = (min + max) >> 1;
            long count = (mid/a) + (mid/b) - (mid/number);
            if(count < n) {
                min = mid + 1;
            }
            else {
                max = mid - 1;
                ans = mid;
            }
        }
        int mod = (int)1e9 + 7;
        ans = ans%mod;

        return (int)ans;
    }
}
