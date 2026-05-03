class Solution {
    public boolean rotateString(String s, String goal) {

        if (s.equals(goal))
            return true;

        StringBuilder sb = new StringBuilder(s);
        int i = 0;

        while (i < s.length()) {

            char ch = sb.charAt(0);
            sb = sb.deleteCharAt(0);
            sb = sb.append(ch);
            i++;

            if (sb.toString().equals(goal))
                return true;
        }

        return false;
    }
}
