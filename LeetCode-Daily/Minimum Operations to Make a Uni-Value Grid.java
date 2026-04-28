class Solution {
    public int minOperations(int[][] grid, int x) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int[] arr : grid)      // whenever we have to make elements equal always use median and remaider property
            for (int num : arr)     // for median we use sorting in ascending order
                list.add(num);      // after that we compare the remainder of all elements with the median when divided by x

        int n = list.size();
        Collections.sort(list);  // sorting to get the median easily

        int UniValue = list.get(n / 2);        // for minimum operation to make all elements equal always take the median value not the averge value
        int ans = 0;

        for (int num : list) {
            if ((num % x) != (UniValue % x))   // if the remainder of all elements are not equal to each other then it is impossible to make it equal by x 
                return -1;

            ans += Math.abs(num - UniValue) / x;  // count operation how much time we have to add or subtract x to make it equal the UniValue
        }

        return ans;
    }
}
