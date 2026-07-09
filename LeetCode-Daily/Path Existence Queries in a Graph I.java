class Solution {
    int parent[];
    int rank[];

    private int find(int node) {
        if (parent[node] == node)
            return node;

        return parent[node] = find(parent[node]);
    }

    private void UnionByRank(int u, int v) {
        int parent_u = find(u);
        int parent_v = find(v);

        if (parent_u == parent_v)
            return;

        if (rank[parent_u] > rank[parent_v]) {
            parent[v] = parent_u;
        } else if (rank[parent_u] < rank[parent_v]) {
            parent[u] = parent_v;
        } else {
            parent[v] = parent_u;
            rank[parent_u] += 1;
        }
    }

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            int u = i-1;
            int v = i;

            if ((nums[v] - nums[u]) <= maxDiff) {
                UnionByRank(u, v);
            }
        }

        boolean ans[] = new boolean[queries.length];
        int ind = 0;

        for (int[] arr : queries) {
            int u = arr[0];
            int v = arr[1];

            ans[ind++] = parent[u] == parent[v];
        }

        return ans;
    }
}
