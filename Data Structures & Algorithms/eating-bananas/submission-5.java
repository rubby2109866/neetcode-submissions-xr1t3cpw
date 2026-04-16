class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 0;
        int r = 0;
        for (int n: piles) {
            r = Math.max(r, n);
        }
        int minHours = r;

        while(l <= r) {
            int mid = l + ((r - l) / 2);
            long hours = getHours(mid, piles);
            if (hours <= h) {
                minHours = Math.min(minHours, mid);
                r = mid - 1;
            } else if (hours > h) {
                l = mid + 1;
            }
        }
        return minHours;
    }
    public long getHours(int k, int[] piles) {
        long hours = 0; 
        for (int n: piles) {
            hours += Math.ceil((double) n / k);
        }
        return hours;
    }
}
