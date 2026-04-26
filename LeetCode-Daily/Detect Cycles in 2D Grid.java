class Solution {
    int[][] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    private boolean cycle(int i, int j, int x, int y, char[][] grid, boolean vis[][]) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[x][y] != grid[i][j])
            return false;

        if (vis[i][j])
            return true;

        vis[i][j] = true;

        for (int[] d : dir) {
            int r = i + d[0];
            int c = j + d[1];

            if (r == x && c == y) 
             continue;

             if (cycle(r, c, i, j, grid, vis))
                return true;    
        }

        return false;
    }

    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean vis[][] = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && cycle(i, j, i, j, grid, vis))
                    return true;
            }
        }

        return false;
    }
}
