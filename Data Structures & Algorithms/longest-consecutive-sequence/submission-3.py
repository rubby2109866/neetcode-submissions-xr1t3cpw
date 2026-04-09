class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        # O(n**2) TC and O(n) SC
        # if nums == []:
        #     return 0
        # h = {}
        # for num in nums:
        #     if num in h:
        #         h[num] += 1
        #     else:
        #         h[num] = 1 
        # result = []
        # for i in range(len(nums)):
        #     current = nums[i]
        #     length = 1
        #     while True:
        #         if current + 1 in h:
        #             length += 1
        #             current += 1
        #         else:
        #             break
        #     result.append(length)
        
        # return max(result)

        # O(N) - TC and O(N) - SC
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
            if (num -1) not in h:
                length = 1
                while (num + length) in h:
                    length += 1
                result = max(result, length)
        return result
