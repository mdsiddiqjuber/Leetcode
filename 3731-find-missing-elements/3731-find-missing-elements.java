class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int largest = 0;
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            if(num < smallest) smallest = num;
            if(num > largest) largest = num;
            set.add(num);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = smallest + 1; i < largest; i++) {
            if(!set.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }
}