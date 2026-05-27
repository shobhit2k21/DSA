class Solution {
    public int numberOfSpecialChars(String word) {
        int[] freqSmall = new int[26];
        int[] freqBig = new int[26];

        Arrays.fill(freqSmall, -1);
        Arrays.fill(freqBig, -1);

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (Character.isLowerCase(ch)) {
                freqSmall[ch - 'a'] = i;
            } else {
                if (freqBig[ch - 'A'] == -1)
                    freqBig[ch - 'A'] = i;
            }
        }

        int ans = 0;

        for (int i = 0; i < 26; i++) {
            if (freqSmall[i] != -1 && freqBig[i] != -1 && freqSmall[i] < freqBig[i])
                ans += 1;
        }

        return ans;
    }
}
