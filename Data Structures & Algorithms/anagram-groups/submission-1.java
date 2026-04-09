class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // SC - O(N) where N is the length of strs
        // TC - O(N)
        HashMap<String, ArrayList<String>> h = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26]; 
            for (int i = 0; i < s.length(); i++) {
                char c1 = s.charAt(i);
                count[c1 - 'a'] += 1;
            }
            String key = Arrays.toString(count);
            if (h.containsKey(key)) {
                h.get(key).add(s);
            } else {
                h.put(key, new ArrayList<>(List.of(s)));
            }
        }
        return new ArrayList<>(h.values());
    }
}
