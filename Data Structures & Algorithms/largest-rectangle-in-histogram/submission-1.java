class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<List<Integer>> stack = new ArrayDeque<>();
        int n = heights.length;
        int area = 0;
        for (int i = 0; i < n; i++) {
            int index = i;
            while (!stack.isEmpty() && stack.peek().get(1) > heights[i]) {
                List<Integer> rectangle = stack.pop();
                index = rectangle.get(0);
                int height = rectangle.get(1);
                area = Math.max(area, (i - index) * height);
            }
            stack.push(List.of(index, heights[i]));
        }
        
        while (!stack.isEmpty()) {
            List<Integer> rec = stack.pop();
            int index = rec.get(0);
            int height = rec.get(1);
            area = Math.max(area, (n - index) * height);
        }
        return area;
    }
}
