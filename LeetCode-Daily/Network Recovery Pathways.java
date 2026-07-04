class Solution {
    int n;

    private boolean isValid(int mid, long k, List<List<int[]>> adj) {
        long dist[] = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.add(new long[] { 0, 0 });
        dist[0] = 0;

        while (!pq.isEmpty()) {
            long[] node = pq.poll();
            int u = (int) node[0];
            long w = node[1];

            if (u == n - 1) {
                return true;
            }

            if (w > dist[u]) {
        continue;
    }

            for (int edge[] : adj.get(u)) {
                int v = edge[0];
                int weight = edge[1];

                if (weight < mid || (weight + w) > k || dist[v] <= (weight + w))
                    continue;

                pq.add(new long[] { v, weight + w });
                dist[v] = w + weight;
            }
        }

        return false;
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        n = online.length;
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int low = 0, high = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (online[v]) {
                adj.get(u).add(new int[] { v, w });
                high = Math.max(high, w);
            }
        }

        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isValid(mid, k, adj)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;

    }
}
