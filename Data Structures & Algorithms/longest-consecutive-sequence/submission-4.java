class Solution {
    public int longestConsecutive(int[] nums) {
        // O(N) - TC and O(N) - SC
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> h = new HashMap<>();
        for (int num : nums) {
            h.put(num, h.getOrDefault(num, 0) + 1);
        } 
        int result = 0;
        for (int num : h.keySet()) {
            if (!h.containsKey(num-1)) {
                int length = 1;
                while (h.containsKey(num + length)) {
                    length++;
                }
                result = Math.max(result, length);
            }
        }
        return result;
    }
}
