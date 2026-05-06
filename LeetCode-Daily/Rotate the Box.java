class Solution {
    private void solve(int start, int end, int row, int stones, char[][] box) {
        if (stones == 0)
            return;

        for (int i = end; i >= start; i--) {
            if (box[row][i] == '*')
                continue;

            if (stones > 0) {
                box[row][i] = '#';
                stones--;
            } else {
                box[row][i] = '.';
            }
        }
    }

    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length, n = boxGrid[0].length;

        for (int i = 0; i < m; i++) {
            int stones = 0;
            int startJ = 0;
            for (int j = 0; j < n; j++) {
                if (boxGrid[i][j] == '#')
                    stones++;
                else if (boxGrid[i][j] == '*') {
                    solve(startJ, j, i, stones, boxGrid);
                    startJ = j;
                    stones = 0;
                }
            }

            solve(startJ, n - 1, i, stones, boxGrid);

        }

        char ans[][] = new char[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = boxGrid[j][i];
            }
        }

        for (int i = 0; i < n; i++) {
            int j = 0, k = m - 1;
            while (j < k) {
                char temp = ans[i][j];
                ans[i][j] = ans[i][k];
                ans[i][k] = temp;

                j++;
                k--;
            }
        }

        return ans;

    }
}
