class Solution {
    public int trap(int[] height) {
        // O(N) - TC and O(1) - SC -> Two Pointer approach
        if (height == null || height.length == 0) {
            return 0;
        }

        int l = 0, r = height.length - 1;
        int leftMax = height[l], rightMax = height[r];
        int res = 0;
        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }
        return res;


        // O(N) - TC and O(N) - SC
        // int n = height.length;
        // int l = 0;
        // int r = n - 1;
        // int leftMax = 0;
        // int rightMax = 0;
        // int[] minLeftRight = new int[height.length];
        // minLeftRight[0] = 0;
        // for (int i = 0; i < n - 1; i++) {
        //     leftMax = Math.max(leftMax, height[i]);
        //     minLeftRight[i + 1] = leftMax;
        // }
        // minLeftRight[n-1] = Math.min(minLeftRight[n-1], rightMax);
        // for (int j = n - 1; j > 0; j--) {
        //     rightMax = Math.max(rightMax, height[j]);
        //     minLeftRight[j - 1] = Math.min(minLeftRight[j - 1], rightMax);
        // }
        // int sum = 0;
        // for(int k = 0; k < n; k++) {
        //     int val = minLeftRight[k] - height[k];
        //     if (val > 0) {
        //         sum += val;
        //     }
        // }
        // return sum;
    }
}
