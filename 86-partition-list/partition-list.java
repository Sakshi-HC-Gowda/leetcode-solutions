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
    public ListNode partition(ListNode head, int x) {
        ListNode lessDummy=new ListNode(0);
        ListNode greaterDummy=new ListNode(0);
        ListNode less = lessDummy;
        ListNode greater = greaterDummy;
        while (head != null) {

            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }

            head = head.next;
        }

        // End the greater list
        greater.next = null;

        // Connect both lists
        less.next = greaterDummy.next;

        return lessDummy.next;
    }
}