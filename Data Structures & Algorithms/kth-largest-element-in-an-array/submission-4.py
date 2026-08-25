class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        return self.quickSelect(nums, 0, len(nums) - 1, len(nums) - k)

    def quickSelect(self, nums, l, r, k):
        pivot = nums[r]
        p = l
        i = l
        for i in range(l, r):
            if nums[i] < pivot: 
                nums[p], nums[i] = nums[i], nums[p]
                p += 1

        nums[p], nums[r] = nums[r], nums[p]
        
        if p > k:
            return self.quickSelect(nums, 0, p - 1, k)
        elif p < k: 
            return self.quickSelect(nums, p + 1, r, k)
        else:
            return nums[p]