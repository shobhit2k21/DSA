class Solution {
    public String smallestPalindrome(String s) {
        int freq[] = new int[26];
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        char arr[] = new char[n];
        int l = 0, r = n - 1;
        int ind = 0;
        char mid = ' ';

        while (l <= r && ind < 26) {
            char ch = (char) ('a' + ind);

            while (ind < 26 && freq[ind] > 1) {
                arr[l] = arr[r] = ch;
                freq[ind] -= 2;
                l++;
                r--;
            }

            if (freq[ind] != 0)
                mid = ch;

            ind++;
        }

        if (mid != ' ')
            arr[l] = mid;

        return new String(arr);
    }
}
