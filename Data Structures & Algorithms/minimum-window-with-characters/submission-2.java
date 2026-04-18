class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length() || t.isEmpty()) {
            return "";
        }
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> countT = new HashMap<>();
        for (Character c: t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }
        int need = countT.size();
        int have = 0;

        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        int resLen = Integer.MAX_VALUE;
        int l = 0;
        for (int r = 0;r < s.length(); r++) {
            char c1 = s.charAt(r);
            if (countT.containsKey(c1)) {
                window.put(c1, window.getOrDefault(c1, 0) + 1);
                if (window.get(c1) == countT.get(c1)) {
                    have += 1;
                }
            }
   
            while (have == need) {
                if ((r - l + 1) < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }
                char c2 = s.charAt(l);
                if (countT.containsKey(c2)) {
                    window.put(c2, window.get(c2) - 1);
                    if (window.get(c2) < countT.get(c2)) {
                        have -= 1;
                    }
                }
                l += 1;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
