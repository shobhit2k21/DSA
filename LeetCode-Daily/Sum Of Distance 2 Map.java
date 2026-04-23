class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long ans[] = new long[n];

        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Long> indices = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];

          if (freq.containsKey(num)) {
                int f = freq.get(num);
                long sum = indices.get(num);
                ans[i] += ((1L * i * f) - sum);
            }

            freq.put(num, freq.getOrDefault(num, 0) + 1);
            indices.put(num, indices.getOrDefault(num, 0L) + i);
        }

        freq.clear();
        indices.clear();

        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];

            if (freq.containsKey(num)) {
                int f = freq.get(num);
                long sum = indices.get(num);
                ans[i] += (sum - (1L * i * f));
            }

            freq.put(num, freq.getOrDefault(num, 0) + 1);
            indices.put(num, indices.getOrDefault(num, 0L) + i);
        }

        return ans;
    }
}
