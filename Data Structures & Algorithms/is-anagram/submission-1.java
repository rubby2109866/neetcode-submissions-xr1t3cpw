class Solution {
    public boolean isAnagram(String s, String t) {
        // O(m + n) - TC
        // O(26) - SC
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26]; 
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            count[c1 - 'a'] += 1;
            count[c2 - 'a'] -= 1;
        }
        
        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
}
