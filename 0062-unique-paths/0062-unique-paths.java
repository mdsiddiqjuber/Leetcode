class Solution {
    // int[][] t;
    // int solve(int i, int j) {
    //     if(i == 0 && j == 0) {
    //         return 1;
    //     }
    //     if(i < 0 || j < 0) {
    //         return 0;
    //     }
    //     if(t[i][j] != -1) {
    //         return t[i][j];
    //     }
    //     int left = solve(i, j - 1);
    //     int up = solve(i - 1, j);
    //     return t[i][j] = left + up;
    // }
    public int uniquePaths(int m, int n) {
        int[][] t = new int[m][n];
        // for(int[] row: t) Arrays.fill(row, -1);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    t[i][j] = 1;
                    continue;
                }
                int left = 0;
                int up = 0;
                if(j > 0) left = t[i][j - 1];
                if(i > 0) up = t[i - 1][j];
                t[i][j] = left + up;
            }
        }
        return t[m - 1][n - 1];
    }
}