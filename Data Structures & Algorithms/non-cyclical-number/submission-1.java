class Solution {
    public boolean isHappy(int n) {
        // Fast and slow pointers TC - O(logn) SC - O(1)
        int slow = n, fast = sumOfSquares(n);

        while (slow != fast) {
            fast = sumOfSquares(fast);
            fast = sumOfSquares(fast);
            slow = sumOfSquares(slow);
        }

        return fast == 1;
        
        // HashSet Method TC - O(logn) SC - O(logn)
        // Set<Integer> visit = new HashSet<>();
        // while (!visit.contains(n)) {
        //     visit.add(n);
        //     n = sumOfSquares(n);
        //     if (n == 1) {
        //         return true;
        //     }
        // }
        // return false;
        
    }

    private int sumOfSquares(int n) {
        int output = 0;

        while (n > 0) {
            int digit = n % 10;
            digit = digit * digit;
            output += digit;
            n /= 10;
        }
        return output;
    }
}
