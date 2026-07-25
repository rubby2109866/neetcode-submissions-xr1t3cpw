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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode prev = new ListNode(0);
        ListNode curr = prev;
        while (list1 != null && list2 != null) {
            if (list1.val == list2.val) {
                ListNode node1 = new ListNode(list1.val);
                ListNode node2 = new ListNode(list2.val);
                curr.next = node1;
                curr = curr.next;
                curr.next = node2;
                curr = curr.next;
                list1 = list1.next;
                list2 = list2.next;
            } else if (list1.val < list2.val) {
                ListNode node = new ListNode(list1.val);
                curr.next = node;
                curr = curr.next;
                list1 = list1.next;
            } else {
                ListNode node = new ListNode(list2.val);
                curr.next = node;
                curr = curr.next;
                list2 = list2.next;
            }
        }
        while (list1 != null) {
            ListNode node = new ListNode(list1.val);
            curr.next = node;
            curr = curr.next;
            list1 = list1.next;
        }

        while (list2 != null) {
            ListNode node = new ListNode(list2.val);
            curr.next = node;
            curr = curr.next;
            list2 = list2.next;
        }
        return prev.next;
    }
}