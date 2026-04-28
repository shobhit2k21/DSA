class Solution {
    public int minOperations(int[][] grid, int x) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int[] arr : grid)
            for (int num : arr)
                list.add(num);

        int n = list.size();
        Collections.sort(list);

        int UniValue = list.get(n / 2);
        int ans = 0;

        for (int num : list) {
            if ((num % x) != (UniValue % x))
                return -1;

            ans += Math.abs(num - UniValue) / x;
        }

        return ans;
    }
}
