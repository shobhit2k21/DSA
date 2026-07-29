class Solution {
    private long nCr(int n, int r, int k) {
        r = Math.min(r, n - r);
        long result = 1;

        for (int i = 1; i <= r; i++) {
            result = result * (n - r + i) / i;

            if (result >= k)
                return k;
        }

        return result;
    }

    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        char mid = ' ';

        if (n % 2 == 1) {
            mid = s.charAt(n / 2);
        }

        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            if (n % 2 == 1 && i == n / 2)
                continue;
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        int half = n / 2;
        StringBuilder sb = new StringBuilder("");
        boolean possible = false;

        for (int i = 0; i < 26; i++) {
            freq[i] /= 2;
        }

        for (int i = 0; i < half; i++) {
            for (int j = 0; j < 26; j++) {
                if (freq[j] > 0) {
                    freq[j] -= 1;

                    long ways = 1;
                    int letters = 0;

                    for (int c = 0; c < 26; c++) {
                        letters += freq[c];
                    }

                    for (int c = 0; c < 26; c++) {
                        if (freq[c] > 0) {
                            ways *= nCr(letters, freq[c], k);
                            letters -= freq[c];
                        }

                        if (ways >= k)
                            break;
                    }

                    if (ways >= k) {
                        sb.append((char) (j + 'a'));
                        possible = true;
                        break;
                    }

                    k -= ways;
                    freq[j] += 1;
                }
            }

              if (possible == false)
                 return "";
        }

        StringBuilder rev = new StringBuilder(sb.reverse());
        sb.reverse();

        if (mid != ' ') {
            sb.append(mid);
        }

        sb.append(rev);

        return sb.toString();
    }
}
