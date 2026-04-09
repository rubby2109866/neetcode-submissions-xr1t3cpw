class Solution {
    public int longestConsecutive(int[] nums) {
        // O(N) - TC and O(N) - SC
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            s.add(num);
        } 
        int result = 0;
        for (int num : s) {
            if (!s.contains(num-1)) {
                int length = 1;
                while (s.contains(num + length)) {
                    length++;
                }
                result = Math.max(result, length);
            }
        }
        return result;
    }
}
