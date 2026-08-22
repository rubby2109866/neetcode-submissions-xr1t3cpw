class Solution:
    def dfs(self, nums, i, curr, res, target):
        if target == 0:
            res.append(curr.copy())
            return
        
        if i >= len(nums) or target < 0: 
            return 

        curr.append(nums[i])
        self.dfs(nums, i, curr, res, target - nums[i]);
        curr.pop();
        self.dfs(nums, i + 1, curr, res, target);

    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = []
        curr = []
        self.dfs(nums, 0, curr, res, target)
        return res

        