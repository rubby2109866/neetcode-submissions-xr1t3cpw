class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // O(N**2) TC and O(1) SC using two pointers
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> triplets = new ArrayList<>(); 
        for (int i = 0 ; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int outerVal = nums[i];
            int target = 0 - outerVal; 
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int val1 = nums[l]; 
                int val2 = nums[r];
                if (val1 + val2 == target) {
                    triplets.add(List.of(outerVal, val1 , val2));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                } else if (val1 + val2 < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return triplets;
        
        // O(N**2) TC and O(N) SC
        // Arrays.sort(nums);
        // int n = nums.length;
        // Set<List<Integer>> triplets = new HashSet<>(); 
        // for (int i = 0 ; i < n; i++) {
        //     int outerVal = nums[i];
        //     int target = 0 - outerVal; 
        //     Set<Integer> seenSet = new HashSet<>();
        //     for (int j = i + 1; j < n; j++) {
        //         int val1 = nums[j]; 
        //         int val2 = target - val1;
        //         if (seenSet.contains(val2)) {
        //             triplets.add(List.of(outerVal, val1 , val2));
        //         } else {
        //             seenSet.add(val1);
        //         }
        //     }
        // }
        // return new ArrayList<>(triplets); 
        // O(N**3)
        // Arrays.sort(nums);
        // int n = nums.length;
        // Set<List<Integer>> triplets = new HashSet<>(); 
        // for (int i = 0 ; i < n; i++) {
        //     for (int j = i + 1 ; j < n; j++) {
        //         for (int k = j + 1; k < n; k++) {
        //             if (nums[i] + nums[j] + nums[k] == 0) {
        //                 triplets.add(List.of(nums[i], nums[j] , nums[k]));
        //             }
        //         }
        //     }  
        // }
        // return new ArrayList<>(triplets); 
    }
}
