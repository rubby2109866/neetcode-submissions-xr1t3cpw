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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr = new ListNode(0);
        ListNode first = curr;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int fir = 0;
            if (l1 != null) {
                fir = l1.val;
                l1 = l1.next;
            }
            int sec = 0;
            if (l2 != null) {
                sec = l2.val;
                l2 = l2.next;
            }
            //int total = l1.val + l2.val + carry;
            int total = fir + sec + carry;
            carry = total / 10;
            curr.next = new ListNode(total % 10);
            //l1 = l1.next;
            //l2 = l2.next;
            curr = curr.next;
        }
        // while (l1 != null) {
        //     int total = l1.val + 0 + carry;
        //     carry = total / 10;
        //     curr.next = new ListNode(total % 10);
        //     l1 = l1.next;
        //     curr = curr.next;
        // }

        // while (l2 != null) {
        //     int total = l2.val + 0 + carry;
        //     carry = total / 10;
        //     curr.next = new ListNode(total % 10);
        //     l2 = l2.next;
        //     curr = curr.next;
        // }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return first.next;
    }
}
