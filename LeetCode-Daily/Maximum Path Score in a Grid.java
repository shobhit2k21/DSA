class Solution {
    private boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    private int dfs(int i, int j, int cost, int[][] grid, int k, int[][][] dp, int m, int n) {
        // If out of bounds or cost exceeds limit → invalid
        if (!isValid(i, j, m, n) || cost > k)
            return (int) -1e9;

        // If at destination
        if (i == m - 1 && j == n - 1) {
            int cellCost = (grid[i][j] == 0 ? 0 : 1);
            int totalCost = cost + cellCost;
            if (totalCost > k) return (int) -1e9;
            return grid[i][j]; // valid path with final cell score
        }

        if (dp[i][j][cost] != -2)
            return dp[i][j][cost];

        int cellCost = (grid[i][j] == 0 ? 0 : 1);
        int newCost = cost + cellCost;
        if (newCost > k) return dp[i][j][cost] = (int) -1e9;

        // Explore right and down moves
        int right = dfs(i, j + 1, newCost, grid, k, dp, m, n);
        int down = dfs(i + 1, j, newCost, grid, k, dp, m, n);

        int best = Math.max(right, down);
        if (best < 0) return dp[i][j][cost] = (int) -1e9;

        return dp[i][j][cost] = grid[i][j] + best;
    }

    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][k + 1];

        for (int[][] arr2d : dp)
            for (int[] arr1d : arr2d)
                Arrays.fill(arr1d, -2);

        int ans = dfs(0, 0, 0, grid, k, dp, m, n);
        return ans < 0 ? -1 : ans;
    }
}
