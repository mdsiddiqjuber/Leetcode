class Solution {
    public void dfs(int[] vis, int node, List<List<Integer>> adj) {
        vis[node] = 1;
        for(int neighbor: adj.get(node)) {
            if(vis[neighbor] == 0) {
                dfs(vis, neighbor, adj);
            }
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        int[] vis = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0 ; i < n; i++) adj.add(new ArrayList<>());
        for(int[] row: invocations) {
            int u = row[0];
            int v = row[1];
            adj.get(u).add(v);
        }
        dfs(vis, k, adj);
        for(int[] row: invocations) {
            int u = row[0];
            int v = row[1];
            if(vis[u] == 0 && vis[v] == 1) {
                for(int i = 0; i < n; i++) {
                    res.add(i);
                }
                return res;
            }
        }
        for(int i = 0; i < n; i++) {
            if(vis[i] == 0){
                res.add(i);
            }
        }
        return res;
    }
}