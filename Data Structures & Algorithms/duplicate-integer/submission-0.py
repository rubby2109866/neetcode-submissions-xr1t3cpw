class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        h = {}
        for n in nums:
            if n in h:
                return True
            h[n] = 1
        return False