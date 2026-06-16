class Solution {
    public String processStr(String s) {
        if (s.length() == 1 && s.charAt(0) == '*')
            return "";

        int l = s.length();
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < l; i++) {
            char ch = s.charAt(i);

            if (Character.isLetter(ch))
                sb.append(ch);
            else if (ch == '*' && sb.length() > 0)
                sb = sb.delete(sb.length() - 1, sb.length());
            else if (ch == '#')
                sb = sb.append(sb);
            else if (ch == '%')
                sb = sb.reverse();
        }

        return sb.toString();

    }
}
