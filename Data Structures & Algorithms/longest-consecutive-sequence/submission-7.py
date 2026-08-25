class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if nums == []:
            return 0
        h = {}
        for num in nums:
            if num in h:
                h[num] += 1
            else:
                h[num] = 1 
        result = 0
        for num in h:
            if (num - 1) not in h:
                length = 1
                while (num + length) in h:
                    length += 1
                result = max(result, length)
        return result
