class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;

        if (n == 1)
          return 0;

        Queue<Integer> q = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        q.add(0);
        boolean vis[] = new boolean[n];

        int steps = 0;
        vis[0] = true;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int ind = q.poll();

                if (ind == n - 1)
                    return steps;

                if (ind - 1 >= 0 && !vis[ind - 1]) {
                    q.add(ind - 1);
                    vis[ind - 1] = true;
                }

                if (ind + 1 < n && !vis[ind + 1]) {
                    q.add(ind + 1);
                    vis[ind + 1] = true;
                }

                if (map.containsKey(arr[ind])) {
                    List<Integer> list = map.get(arr[ind]);
                    for (int num : list) {
                        q.add(num);
                        vis[num] = true;
                    }
                    map.remove(arr[ind]);
                }
            }

            steps++;
        }

        return steps;
    }
}
