class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] ans = new int[n];

        int pivotFreq = 0;
        int ind = 0;

        for (int i = 0; i < n; i++) {
            if (pivot == nums[i]) {
                pivotFreq++;
            } else if (pivot > nums[i]) {
                ans[ind++] = nums[i];
            }
        }

        for (int i = pivotFreq; i > 0; i--) {
            ans[ind++] = pivot;
        }

        for (int i = 0; i < n; i++) {
            if (pivot < nums[i]) {
                ans[ind++] = nums[i];
            }
        }

        return ans;
    }
}
