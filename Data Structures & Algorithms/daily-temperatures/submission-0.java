class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // O(N**2) - TC and O(N) - SC
        int l = temperatures.length;
        int[] numberOfDays = new int[l];
        
        for (int i = 0; i < l; i++) {
            int temp = temperatures[i];
            int warmTempDays = 0;
            for (int j = i + 1; j < l; j++) {
                warmTempDays += 1;
                if (temperatures[j] > temp) {
                    numberOfDays[i] = warmTempDays;
                    break;
                } 
            }
        }
        return numberOfDays;
    }
}
