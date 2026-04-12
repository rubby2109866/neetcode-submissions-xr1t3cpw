class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //O(N) - TC and O(N) - SC
        int l = temperatures.length;
        int[] numberOfDays = new int[l];
        Deque<List<Integer>> stack = new ArrayDeque<>();
        stack.push(List.of(temperatures[0], 0));
        for (int i = 1; i < l; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && temp > stack.peek().get(0)) {
                int index = stack.pop().get(1);
                numberOfDays[index] = (i - index);
            }
            stack.push(List.of(temp, i));
        }
        return numberOfDays;

        // O(N**2) - TC and O(N) - SC
        // int l = temperatures.length;
        // int[] numberOfDays = new int[l];
        
        // for (int i = 0; i < l; i++) {
        //     int temp = temperatures[i];
        //     int warmTempDays = 0;
        //     for (int j = i + 1; j < l; j++) {
        //         warmTempDays += 1;
        //         if (temperatures[j] > temp) {
        //             numberOfDays[i] = warmTempDays;
        //             break;
        //         } 
        //     }
        // }
        // return numberOfDays;
    }
}
