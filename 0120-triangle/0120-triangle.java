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
        int[][] dp = new int[n][n];
        //for(int[] row: dp) Arrays.fill(row, -1);
        //return solve(triangle, 0, 0);
        for(int i = 0; i < n; i++) {
            dp[n - 1][i] = triangle.get(n - 1).get(i);
        }
        for(int i = n - 2; i >= 0; i--) {
            for(int j = i; j >= 0; j--) {
                int down = triangle.get(i).get(j) + dp[i + 1][j];
                int diag = triangle.get(i).get(j) + dp[i + 1][j + 1];
                dp[i][j] = Math.min(down, diag);
            }
        }
        return dp[0][0];
    }
}