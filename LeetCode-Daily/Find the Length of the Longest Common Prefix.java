class Solution {
    HashSet<Integer> set = new HashSet<>();
    private void PutPrefix(int num) {
        int div = 1;
        int temp = num;

        while (temp >= 10) {
            div *= 10;
            temp /= 10;
        }

        while (div > 0) {
            set.add(num / div);
            div /= 10;
        }
    }

    private int longestPrefix(int num) {
        int div = 1;
        int temp = num;

        while (temp >= 10) {
            div *= 10;
            temp /= 10;
        }
        int c = 0;
        int ans = 0;

        while (div > 0) {
            c++;
            int pre = (num / div);
            if (set.contains(pre))
                ans = c;
            div /= 10;
        }

        return ans;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int ans = 0;
        int n = arr1.length, m = arr2.length;

        for (int num : arr1)
            PutPrefix(num);

        for (int i = 0; i < m; i++) {
            ans = Math.max(ans, longestPrefix(arr2[i]));
        }

        return ans;
    }
}
