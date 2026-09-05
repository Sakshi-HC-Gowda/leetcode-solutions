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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode beforeLeft=dummy;
        for(int i=1;i<left;i++){
            beforeLeft=beforeLeft.next;
        }
        // Save the original left node
        ListNode leftNode = beforeLeft.next;

        //Reversal
        ListNode curr=beforeLeft.next;
        ListNode prev=null;

        // reverse (right-left+1) nodes
        for (int i = 0; i < right - left + 1; i++) {
        ListNode next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
    }
      // Reconnect left side
        beforeLeft.next=prev;

        // Reconnect right side
        leftNode.next=curr;

        return dummy.next;
    }
}