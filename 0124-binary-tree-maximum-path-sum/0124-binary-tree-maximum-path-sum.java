/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }
    public int dfs(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int l = Math.max(dfs(node.left), 0);
        int r = Math.max(dfs(node.right), 0);
        int temp = Math.max(node.val, Math.max(l, r) + node.val);
        int ans = Math.max(temp, l + r + node.val);
        res = Math.max(res, ans);
        return temp;
    }
}