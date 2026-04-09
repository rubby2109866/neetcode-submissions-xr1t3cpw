class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        # O(n ** 2) Time complexity
        result = []
        l = len(nums)
        for i in range(l):
            product = 1
            for j in range(l):
                if i == j:
                    continue
                product *= nums[j]
            result.append(product)
        return result
         

            