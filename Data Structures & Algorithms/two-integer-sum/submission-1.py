class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
       # Hashmap one pass
        prev = {}

        for i,n in enumerate(nums):
            diff = target - n
            if diff in prev:
                return [prev[diff], i]
            prev[n] = i

        # Hashmap two pass
        # indices = {}

        # for i, n in enumerate(nums):
        #     indices[n] = i

        # for i,n in enumerate(nums):
        #     diff = target - n
        #     if diff in indices and indices[diff] != i:
        #         return [indices[diff], i] 

        # Brute force
        # for i in range(len(nums)):
        #     for j in range(i + 1, len(nums)):
        #         if nums[i] + nums[j] == target:
        #             return [i,j] 
 