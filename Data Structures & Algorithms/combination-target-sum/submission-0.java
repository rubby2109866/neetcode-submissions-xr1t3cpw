class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        dfs(nums, 0, curr, res, target);
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> curr, List<List<Integer>> res, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (i >= nums.length || target < 0) {
            return;
        }

        curr.add(nums[i]);
        dfs(nums, i, curr, res, target - nums[i]);
        curr.remove(curr.size() - 1);
        dfs(nums, i + 1, curr, res, target);
    }
}
