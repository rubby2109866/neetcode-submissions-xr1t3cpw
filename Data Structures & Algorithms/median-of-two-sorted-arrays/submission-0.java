class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // O(log(min(m,n))) - TC
        int s1 = nums1.length;
        int s2 = nums2.length;
        int total = s1 + s2;
        int half = (total + 1) / 2;
        int[] smallerArray;
        int[] largerArray;
        if (s1 > s2) {
            smallerArray = nums2;
            largerArray = nums1;
        } else {
            largerArray = nums2;
            smallerArray = nums1;
        }
    
        int l = 0;
        int r = smallerArray.length;
        while (l <= r) {
            int i = (l + r) / 2;
            int j = half - i;

            int Aleft = i > 0 ? smallerArray[i - 1] : Integer.MIN_VALUE;
            int Aright = i < smallerArray.length ? smallerArray[i] : Integer.MAX_VALUE;
            int Bleft = j > 0 ? largerArray[j - 1] : Integer.MIN_VALUE;
            int Bright = j < largerArray.length ? largerArray[j] : Integer.MAX_VALUE;

            if (Aleft <= Bright && Bleft <= Aright) {
                if (total % 2 != 0) {
                    return Math.max(Aleft, Bleft);
                }
                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
            } else if (Aleft > Bright) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
        return -1;
    }
}
