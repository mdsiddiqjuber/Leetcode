class Solution {
    int[] t;
    int solve(int[] nums, int idx) {
        if(idx == 0) return nums[idx];
        if(idx < 0) return 0;
        if(t[idx] != -1) return t[idx];
        int pick = nums[idx] + solve(nums, idx - 2);
        int notPick = 0 + solve(nums, idx - 1);
        return t[idx] = Math.max(pick, notPick);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        t = new int[n];
        Arrays.fill(t, -1);
        return solve(nums, n - 1);
    }
}