class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        # O(n ** 2) Time complexity
        # result = []
        # l = len(nums)
        # for i in range(l):
        #     product = 1
        #     for j in range(l):
        #         if i == j:
        #             continue
        #         product *= nums[j]
        #     result.append(product)
        # return result

        # O(n) Time complexity suffix/prefix method and extra space O(N)
        # n = len(nums)
        # result = [0] * n
        # pref = [0] * n
        # suff = [0] * n
        

        # pref[0] = suff[n-1] = 1

        # for i in range(1, n):
        #     pref[i] = (pref[i-1] * nums[i-1])
            
    
        # for j in range(n-2, -1, -1):
        #     suff[j] = nums[j + 1] * suff[j + 1]
            
        # for i in range(n):
        #     result[i] = pref[i] * suff[i]
        
        
        # return result

        # O(n) Time complexity suffix/prefix method and extra space O(N)
        n = len(nums)
        result = [1] * n
        
        prefix = 1
        for i in range(n):
            result[i] = prefix
            prefix *= nums[i]
        
        postfix = 1
        for i in range(n-1, -1, -1):
            result[i] *= postfix
            postfix *= nums[i]
        
        return result
            