class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int maxi = 0;
        for (int e : costs)
            maxi = Math.max(e, maxi);

        int freq[] = new int[maxi + 1];
        for (int e : costs)
            freq[e] += 1;

        int ans = 0;
        int ind = 1;

        while (ind < freq.length && coins >= ind) {
            if (freq[ind] == 0) {
                ind++;
                continue;
            }
            int mini = coins / ind;
            ans += Math.min(mini, freq[ind]);
            coins -= Math.min(mini, freq[ind]) * ind;
            ind++;
        }

        return ans;
    }
}
