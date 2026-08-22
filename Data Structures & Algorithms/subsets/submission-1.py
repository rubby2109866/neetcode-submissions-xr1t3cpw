class Solution:
    def dfs(self, nums, i, subset, res):
        if i >= len(nums): 
            res.append(subset.copy())
            return 

        subset.append(nums[i])
        self.dfs(nums, i + 1, subset, res);
        subset.pop();
        self.dfs(nums, i + 1, subset, res);
    

    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        subset = []
        self.dfs(nums, 0, subset, res)
        return res