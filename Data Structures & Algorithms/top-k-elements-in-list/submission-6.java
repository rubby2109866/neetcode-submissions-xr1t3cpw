class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Bucket Sort O(N)
        Map<Integer, Integer> h = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            h.put(val, h.getOrDefault(val, 0) + 1);
        }
        
        List<List<Integer>> freq = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length + 1; i++) {
            freq.add(new ArrayList<>());
        }
        
        for (Map.Entry<Integer, Integer> entry : h.entrySet()) {
            int num = entry.getKey();
            int val = entry.getValue();
            freq.get(val).add(num);
        }

        List<Integer> result = new ArrayList<>();
        for (int j = freq.size() - 1; j >=0; j--) {
            for (Integer res: freq.get(j)) {
                result.add(res);
                if (result.size() == k) {
                    return result.stream().mapToInt(Integer::intValue).toArray();
                }
            }
        } 

        return null;
        // Heap approach O(NLOGK)
        // Map<Integer, Integer> h = new HashMap<>();

        // for (int i = 0; i < nums.length; i++) {
        //     int val = nums[i];
        //     h.put(val, h.getOrDefault(val, 0) + 1);
        // }

        // PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // for (int num : h.keySet()) {
        //     heap.offer(new int[]{h.get(num), num});

        //     if (heap.size() > k) {
        //         heap.poll();
        //     }
        // }

        // List<Integer> res = new ArrayList<>();

        // while (!heap.isEmpty()) {
        //     res.add(heap.poll()[1]);
        // }

        // return res.stream().mapToInt(Integer::intValue).toArray();
        
        
        // HashMap and sorting approach O(NLOGN)
        // Map<Integer, Integer> h = new HashMap<>();

        // for (int i = 0; i < nums.length; i++) {
        //     int val = nums[i];
        //     h.put(val, h.getOrDefault(val, 0) + 1);
        // }

        // List<int[]> arr = new ArrayList<>();

        // for (Map.Entry<Integer, Integer> entry : h.entrySet()) {
        //     arr.add(new int[]{entry.getValue(), entry.getKey()});
        // }

        // Collections.sort(arr, (a, b) -> Integer.compare(b[0], a[0]));

        // List<Integer> res = new ArrayList<>();

        // for (int i = 0; i < k; i++) {
        //    res[i] = arr.get(i)[1];
        // }

        // return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
