class Solution:
    def dfs(self, candidates, i, curr, res, target):
        if target == 0:
            res.append(curr.copy())
            return
            
        if i >= len(candidates) or target < 0: 
            return 

        curr.append(candidates[i])
        self.dfs(candidates, i + 1, curr, res, target - candidates[i]);
        curr.pop();
        while i + 1 < len(candidates) and candidates[i] == candidates[i+1]:
            i += 1
        self.dfs(candidates, i + 1, curr, res, target);

    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        candidates.sort()
        self.dfs(candidates, 0, [], res, target)
        return res
        