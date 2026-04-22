class Solution {
    private boolean check(String a, String b) {
        int cnt = 0;
        for (int k = 0; k < a.length(); k++) {
            if (a.charAt(k) != b.charAt(k))
                cnt++;
        }

        if (cnt <= 2)
            return true;

        return false;
    }

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        int n = dictionary.length;
        int q = queries.length;

         List<String> list = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            String quer = queries[i];
            for (int j = 0; j < n; j++) {
                String dic = dictionary[j];
                if (check(quer, dic)) {
                    list.add(quer);
                    break;
                }
            }
        }

        return list;
    }
}
