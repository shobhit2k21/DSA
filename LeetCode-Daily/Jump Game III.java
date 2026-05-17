class Solution {
    private boolean solve(int[] arr, int start, boolean[] vis) {
        if (start < 0 || start >= arr.length)
            return false;
        if (arr[start] == 0)
            return true;

        if (vis[start]) return false;
          vis[start] = true;

        return (solve(arr, start + arr[start], vis) || solve(arr, start - arr[start], vis));
    }

    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean vis[] = new boolean[n];

        return solve(arr, start, vis);
    }
}
