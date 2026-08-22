class Solution:
    def dfs(self, nums, i, curr, res, target):
        if target == 0:
            res.append(curr.copy())
            return
        
        if target < 0: 
            return 

        for j in range(i, len(nums)):
            curr.append(nums[j])
            self.dfs(nums, j, curr, res, target - nums[j]);
            curr.pop();

    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = []
        curr = []
        self.dfs(nums, 0, curr, res, target)
        return res

        