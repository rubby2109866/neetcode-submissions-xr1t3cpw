class Solution {
    public int findMin(int[] nums) {
        // O(n) TC
        // int mini = Integer.MAX_VALUE;
        // for (int num: nums) {
        //     mini = Math.min(mini, num);
        // }
        // return mini;

        int res = Integer.MAX_VALUE;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] < nums[r]) {
                res = Math.min(res, nums[l]);
                break;
            }
            int m = (l + r) / 2;
            res = Math.min(res , nums[m]);
            if (nums[m] >= nums[l]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }
}
