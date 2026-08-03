class Solution {
    public int solve(int[] nums) {
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
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] temp1 = new int[n - 1];
        int[] temp2 = new int[n - 1];
        for(int i = 0; i < n; i++) {
            if(i != 0) temp1[i - 1] = nums[i];
            if(i != n - 1) temp2[i] = nums[i];
        }
        int first = solve(temp1);
        int second = solve(temp2);
        return Math.max(first, second);
    }
}