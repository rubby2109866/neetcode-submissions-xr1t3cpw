class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int l, int r,int k) {
        int pivot = nums[r];
        int p = l;
        for (int i = l; i < r; i++) {
            if (nums[i] < pivot) {
                int temp = nums[p];
                nums[p] = nums[i];
                nums[i] = temp;
                p += 1; 
            }
        }

        int temp = nums[r];
        nums[r] = nums[p];
        nums[p] = temp;
        
        if (p > k) {
            return quickSelect(nums, 0, p - 1, k);
        } else if (p < k) {
            return quickSelect(nums, p + 1, r, k);
        } else {
            return nums[p];
        }
    }
}
