class Solution {
    int mod = (int) 1e9 + 7;

    private int height(List<List<Integer>> edge, boolean[] vis) {
        int ans = -1;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int node = q.poll();
                for (int e : edge.get(node)) {
                    if (vis[e])
                        continue;

                    vis[e] = true;
                    q.add(e);
                }
            }

            ans++;
        }

        return ans;
    }

    private long power(long base, long exp) {
        long ans = 1;

        while (exp > 0) {
            if (exp % 2 == 1) {
                ans = (ans * base) % mod;
            }

            base = (base * base) % mod;
            exp = exp >> 1;
        }

        return ans;
    }

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> edge = new ArrayList<>();
        for (int i = 0; i <= n + 1; i++)
            edge.add(new ArrayList<>());

        for (int a[] : edges) {
            edge.get(a[0]).add(a[1]);
            edge.get(a[1]).add(a[0]);
        }

        boolean[] vis = new boolean[n + 2];
        vis[1] = true;

        long h = height(edge, vis);
        return (int) power(2, h - 1);
    }
}
