class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] freq = new int[51];
        int n = A.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            if (freq[A[i]] > 0)
                ans[i]++;
            freq[A[i]]++;

            if (freq[B[i]] > 0)
                ans[i]++;
            freq[B[i]]++;

            ans[i] += i > 0 ? ans[i - 1] : 0;
        }

        return ans;
    }
}
