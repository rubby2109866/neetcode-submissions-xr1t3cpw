class Solution {
    public double myPow(double x, int n) {
        double res = helper(x , Math.abs(n));
        if (n > 0) return res;
        return 1/res;

        // brute force solution TC - n
        // if (x == 0) {
        //     return 0;
        // }
        // if (n == 0) {
        //     return 1;
        // }
        // int i = 1;
        // double res = x;
        // while (i != Math.abs(n)) {
        //     res *= x;
        //     i += 1;
        // }
        // if (n > 0) return res;
        // return 1/res;
    }
    public double helper(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        double res = helper(x, n / 2);
        res = res * res;
        if (n % 2 == 1) {
            return x * res;
        } else {
            return res;
        }  
    }
}
