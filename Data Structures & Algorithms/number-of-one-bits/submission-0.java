class Solution {
    public int hammingWeight(int n) {
        // Bit Mask Method 
        int res = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                res += 1;
            } 
            n = n >> 1;
        }
        return res;
    }
}
