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
        //  if(head==null || left==right)
        //     return head;
         ListNode dummy=new ListNode(0);
         dummy.next=head;

         ListNode leftpre=dummy;
        ListNode curr=head;
        ListNode prev=null;
         for(int i=0;i<left-1;i++){
            leftpre=leftpre.next;
            curr=curr.next;
         }
        //  where new head is starting
         ListNode subhead=curr;

         for(int i=0;i<=right-left;i++){
             ListNode ahead=curr.next;
             curr.next=prev;
             prev=curr;
             curr=ahead;
         }
        //  joining the broken parts
         leftpre.next=prev;
         subhead.next=curr;

         return dummy.next;
    }
}