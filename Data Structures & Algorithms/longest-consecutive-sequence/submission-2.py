class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        # O(n) TC and O(n) SC
        if nums == []:
            return 0
        h = {}
        for num in nums:
            if num in h:
                h[num] += 1
            else:
                h[num] = 1 
        result = []
        for i in range(len(nums)):
            current = nums[i]
            length = 1
            while True:
                if current + 1 in h:
                    length += 1
                    current += 1
                else:
                    break
            result.append(length)
        
        return max(result)