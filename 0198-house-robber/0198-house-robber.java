class Solution {
    // int[] t;
    // int solve(int[] nums, int idx) {
    //     if(idx == 0) return nums[idx];
    //     if(idx < 0) return 0;
    //     if(t[idx] != -1) return t[idx];
    //     int pick = nums[idx] + solve(nums, idx - 2);
    //     int notPick = 0 + solve(nums, idx - 1);
    //     return t[idx] = Math.max(pick, notPick);
    // }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] t = new int[n];
        Arrays.fill(t, -1);
        t[0] = nums[0];
        for(int i = 1; i < n; i++) {
            int pick = nums[i];
            if(i > 1) pick += t[i - 2];
            int notPick = t[i - 1];
            t[i] = Math.max(pick, notPick);
        }
        return t[n - 1];
    }
}