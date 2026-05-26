class Solution {
    public int numberOfSpecialChars(String word) {
        int[] small = new int[26];
        int[] big = new int[26];

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (Character.isLowerCase(ch)) {
                small[ch - 'a']++;
            } else {
                big[ch - 'A']++;
            }
        }

        int ans = 0;

        for (int i = 0; i < 26; i++) {
          if(small[i] > 0 && big[i] > 0)  
            ans += 1;
        }

        return ans;
    }
}
