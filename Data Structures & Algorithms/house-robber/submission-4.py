class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        num1 = nums[0]
        num2 = max(nums[0], nums[1])
        curr = num2
        for i in range(2, len(nums)):
            curr = max(num2, nums[i] + num1)
            num1 = num2
            num2 = curr
            
        return curr
