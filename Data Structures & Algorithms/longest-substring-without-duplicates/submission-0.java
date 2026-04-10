class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> unique = new HashSet<>();
        int l = 0;
        if (s.length() == 0) {
            return 0;
        }
        int res = 0;
        for (int r = 0; r < s.length(); r++) {
            char val = s.charAt(r);
            while (unique.contains(val)) {
                unique.remove(s.charAt(l));
                l += 1;
            }
            unique.add(val);
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
