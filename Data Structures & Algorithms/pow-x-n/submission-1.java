class Solution {
    public double myPow(double x, int n) {
        // brute force solution but this causes tle 
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        int i = 1;
        double res = x;
        while (i != Math.abs(n)) {
            res *= x;
            i += 1;
        }
        if (n > 0) return res;
        return 1/res;
    }
}
