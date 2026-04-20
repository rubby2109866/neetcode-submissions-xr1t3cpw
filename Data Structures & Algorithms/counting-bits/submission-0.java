class Solution {
    public int[] countBits(int n) {
        // Bit Mask Method
        

        int[] output = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int num = i;
            int res = 0;
            while (num != 0) {
                if ((num & 1) == 1) {
                    res += 1;
                }
                num = num >> 1;
            }
            output[i] = res;
        }
        return output;
    }
}
