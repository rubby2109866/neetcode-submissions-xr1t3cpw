class Solution {
    public int maxProfit(int[] prices) {
        // O(N) - TC O(1) - SC
        int res = 0;
        int l = 0;
        int r = 1;
        while (r < prices.length) {
            
            if (prices[l] >= prices[r]) {
                l = r;
            } else {
                res = Math.max(res, prices[r] - prices[l]);
            }
            r++;
        }
        return res;
        // O(N**2) - TC O(1) - SC
        // int res = 0;
        // for (int i = 0; i < prices.length; i++) {
        //     for (int j = i + 1; j < prices.length; j++) {
        //         res = Math.max(res, prices[j] - prices[i]);
        //     }
        // }
        // return res;
    }
}
