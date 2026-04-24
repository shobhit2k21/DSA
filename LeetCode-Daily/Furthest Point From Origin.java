class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int R = 0, L = 0, dash = 0;
        int n = moves.length();

        for (int i = 0; i < n; i++) {
            char ch = moves.charAt(i);
            if (ch == 'L')
                L++;
            else if (ch == 'R')
                R++;
            else
                dash++;
        }

        int result = Math.abs(L - R);

        return result + dash;
    }
}
