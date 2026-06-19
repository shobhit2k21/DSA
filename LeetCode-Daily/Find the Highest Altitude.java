class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0, prefix = 0;

        for (int e : gain) {
            prefix += e;
            ans = Math.max(ans, prefix);
        }

        return ans;
    }
}
