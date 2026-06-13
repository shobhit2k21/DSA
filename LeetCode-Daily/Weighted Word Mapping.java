class Solution {
    private char solve(int num) {
        char ch = (char) ('z' - num);
        return ch;
    }

    public String mapWordWeights(String[] words, int[] weights) {
        int n = words.length;
        StringBuilder sb = new StringBuilder("");

        for (String s : words) {
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                sum += weights[s.charAt(i) - 'a'];
            }
            sum %= 26;
            sb.append(solve(sum));
        }

        return sb.toString();
    }
}
