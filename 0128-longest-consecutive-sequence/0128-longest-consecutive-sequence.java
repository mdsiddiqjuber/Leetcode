class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        for(int num: set) {
            if(!set.contains(num - 1)) {
                int count = 1;
                while(set.contains(num + 1)) {
                    count++;
                    num++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}