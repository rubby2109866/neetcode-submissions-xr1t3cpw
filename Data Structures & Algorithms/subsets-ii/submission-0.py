class Solution:
    def dfs(self, nums, i, subset, res):
        if i >= len(nums): 
            res.append(subset.copy())
            return 

        subset.append(nums[i])
        self.dfs(nums, i + 1, subset, res);
        subset.pop();
        while (i + 1 < len(nums) and nums[i] == nums[i + 1]):
            i += 1
        self.dfs(nums, i + 1, subset, res);

    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        res = []
        subset = []
        nums.sort()
        self.dfs(nums, 0, subset, res)
        return res