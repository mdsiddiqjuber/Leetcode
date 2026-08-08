class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int total = 0;
        for (int x : nums) {
            total += x;
        }
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = nums[i];
            right[i] = nums[i + n];
        }
        List<Integer>[] leftSums = new ArrayList[n + 1];
        List<Integer>[] rightSums = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            leftSums[i] = new ArrayList<>();
            rightSums[i] = new ArrayList<>();
        }
        generate(left, leftSums);
        generate(right, rightSums);
        for (int i = 0; i <= n; i++) {
            Collections.sort(rightSums[i]);
        }
        int answer = Integer.MAX_VALUE;
        for (int k = 0; k <= n; k++) {
            List<Integer> rightList = rightSums[n - k];
            for (int leftSum : leftSums[k]) {
                int target = total / 2 - leftSum;
                int index = Collections.binarySearch(rightList, target);
                if (index < 0) {
                    index = -index - 1;
                }
                // Candidate at index
                if (index < rightList.size()) {
                    int sum = leftSum + rightList.get(index);
                    answer = Math.min(answer, Math.abs(total - 2 * sum));
                }
                // Candidate just before index
                if (index > 0) {
                    int sum = leftSum + rightList.get(index - 1);
                    answer = Math.min(answer, Math.abs(total - 2 * sum));
                }
            }
        }
        return answer;
    }
    private void generate(int[] arr, List<Integer>[] sums) {
        int n = arr.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += arr[i];
                    count++;
                }
            }
            sums[count].add(sum);
        }
    }
}