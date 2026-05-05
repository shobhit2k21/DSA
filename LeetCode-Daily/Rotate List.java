/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        int count = 0;
        ListNode temp = head;

        while (temp != null) {
            count++;
            if (temp.next == null) {
                if (k % count == 0)
                    return head;

                temp.next = head;
                break;
            }
            temp = temp.next;
        }

        ListNode newHead = null;
        int rotate = k % count;
        int c = 0;
        temp = head;

        while (true) {
            c++;
            if (c == (count - rotate)) {
                newHead = temp.next;
                temp.next = null;
                break;
            }
            temp = temp.next;
        }

        return newHead;

    }
}
