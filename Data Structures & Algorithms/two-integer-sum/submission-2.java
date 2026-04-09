class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Hashmap one pass
        HashMap<Integer, Integer> prev = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int diff = target - n;
            if (prev.containsKey(diff)) {
                return new int[]{prev.get(diff), i};
            }
            prev.put(n,i);
        }
        return null;
    }
}
