class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap =
    new PriorityQueue<>((a, b) -> b[2] - a[2]);

        for (int[] point: points) {
            int x = point[0];
            int y = point[1];
            int distance = x * x + y * y;
            maxHeap.offer(new int[]{x, y, distance});
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        int i = 0;
        while (k > 0) {
            int[] temp = maxHeap.poll();
            result[i] = new int[]{temp[0],temp[1]};
            k -= 1;
            i += 1;
        }
        return result;
    }
}
