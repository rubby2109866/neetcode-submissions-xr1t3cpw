class Solution {

    public String encode(List<String> strs) {
        String s = "";
        if (strs == null) {
            return s;
        }
        
        for (String st : strs) {
            int l = st.length();
            s += l + "#" + st;
        }
        return s;
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j += 1;
            }
            int l = Integer.parseInt(str.substring(i,j));
            i = j + 1;
            j = i + l;
            res.add(str.substring(i,j));
            i = j;
        }
        return res; 
    }
}
