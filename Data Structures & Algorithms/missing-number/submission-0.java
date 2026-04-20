class Solution {
    public int missingNumber(int[] nums) {
        // Brute force solution would be to use a set and then just 
        // check for the presence of each number
        int res = 0;
        for (int i = 0; i <= nums.length; i++) {
            res = res ^ i;
        }
        for (int n: nums) {
            res = res ^ n;
        }
        return res;
    }
}
