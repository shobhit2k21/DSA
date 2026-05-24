class Solution {
    private int solve(int ind, int[] dp, int[] arr, int d) {
        if (dp[ind] != -1)   // always call recursion if it was visited it give solve ans 
            return dp[ind];  // never put condition before calling like if(dp[ind - i] == -1)
                             // bcz if it fails you canot store the ans of repeated prblm as you dpnt call the funcion
                             // so call every time and always check that visited condition at beginning
        int maxi = 0;
        boolean forw = true;
        boolean back = true;

        for (int i = 1; i <= d; i++) {
            if (ind - i >= 0 && arr[ind] <= arr[ind - i]) {
                back = false;
            }
            if (ind - i >= 0 && arr[ind] > arr[ind - i] && back) {
                maxi = Math.max(maxi, 1 + solve(ind - i, dp, arr, d));
            }

            if (ind + i < arr.length && arr[ind] <= arr[ind + i]) {
                forw = false;
            }
            if (ind + i < arr.length && arr[ind] > arr[ind + i] && forw) {
                maxi = Math.max(maxi, 1 + solve(ind + i, dp, arr, d));
            }
        }

        return dp[ind] = maxi;
    }

    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == -1)
                ans = Math.max(ans, solve(i, dp, arr, d));
        }

        return ans + 1;
    }
}
