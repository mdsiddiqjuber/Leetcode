class Solution {
    // int[][] dp;
    // int solve(List<List<Integer>> triangle, int i, int j) {
    //     if(i == triangle.size() - 1) {
    //         return triangle.get(i).get(j);
    //     }
    //     if(dp[i][j] != -1) return dp[i][j];
    //     int oneStep = triangle.get(i).get(j) + solve(triangle, i + 1, j);
    //     int twoStep = triangle.get(i).get(j) + solve(triangle, i + 1, j + 1);
    //     return dp[i][j] = Math.min(oneStep, twoStep);
    // }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        //for(int[] row: dp) Arrays.fill(row, -1);
        //return solve(triangle, 0, 0);
        for(int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }
        for(int i = n - 2; i >= 0; i--) {
            int[] temp = new int[i + 1];
            for(int j = i; j >= 0; j--) {
                int down = triangle.get(i).get(j) + dp[j];
                int diag = triangle.get(i).get(j) + dp[j + 1];
                temp[j] = Math.min(down, diag);
            }
            dp = temp;
        }
        return dp[0];
    }
}