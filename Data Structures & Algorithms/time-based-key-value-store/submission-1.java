class Pair {
    String str;
    int num;

    Pair(String str, int num) {
        this.str = str;
        this.num = num;
    }
    String getString() {
        return str;
    }
    int getNum() {
        return num;
    }
}

class TimeMap {
    Map<String, List<Pair>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.putIfAbsent(key, new ArrayList<>());
        timeMap.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        String res = "";
        List<Pair> values = timeMap.get(key);
        if (values == null) {
            return res;
        }
        int l = 0;
        int r = values.size() - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (values.get(mid).getNum() <= timestamp) {
                res = values.get(mid).getString();
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
