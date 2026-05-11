class Solution {
    public int[] separateDigits(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String num = Integer.toString(nums[i]);

            for (int j = 0; j < num.length(); j++) {
                list.add(num.charAt(j) - '0');
            }
        }

        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
        return arr;
    }
}
