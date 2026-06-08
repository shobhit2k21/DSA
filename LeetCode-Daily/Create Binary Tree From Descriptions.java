/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private void create(HashMap<Integer, TreeNode> map, int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            TreeNode node = null;

            if (map.containsKey(arr[i][0]))
                node = map.get(arr[i][0]);
            else {
                node = new TreeNode(arr[i][0]);
                map.put(arr[i][0], node);
            }

            int dir = arr[i][2];

            if (map.containsKey(arr[i][1])) {
                if (dir == 1)
                    node.left = map.get(arr[i][1]);
                else
                    node.right = map.get(arr[i][1]);
            } else {
                TreeNode child = new TreeNode(arr[i][1]);
                if (dir == 1)
                    node.left = child;
                else
                    node.right = child;

                map.put(arr[i][1], child);
            }
        }
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> set = new HashSet<>();
        HashMap<Integer, TreeNode> map = new HashMap<>();
        create(map, descriptions);

        for (int a[] : descriptions) {
            set.add(a[1]);
        }

        for (int a[] : descriptions) {
            if (!set.contains(a[0]))
                return map.get(a[0]);
        }

        return null;
    }
}
