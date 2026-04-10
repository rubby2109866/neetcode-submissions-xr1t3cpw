class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> countMap = new HashMap<>();
        int l = 0;
        int res = 0;
        for (int r = 0;r < s.length(); r++) {
            char c = s.charAt(r);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);

            if ((r - l + 1) - findMax(countMap) > k) {
                countMap.put(s.charAt(l), countMap.get(s.charAt(l)) - 1);
                l += 1;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
    public int findMax(Map<Character, Integer> map) {
        int max = Integer.MIN_VALUE;
        for (int value : map.values()) {
            max = Math.max(max, value);
        }
        return max;
    }
}
