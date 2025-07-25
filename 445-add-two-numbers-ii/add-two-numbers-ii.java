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
        ListNode list1=reverselist(l1);
        ListNode list2=reverselist(l2);
       
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        int carry=0;
        while(list1!=null || list2!=null){
            int sum=carry;
            if(list1!=null){
                sum+=list1.val;
                list1=list1.next;
            }
            if(list2!=null){
                sum+=list2.val;
                list2=list2.next;
            }
            ListNode node=new ListNode(sum%10);
            carry=sum/10;

            curr.next=node;
            curr=curr.next;

        }
        if(carry!=0){
            ListNode new_node=new ListNode(carry);
            curr.next=new_node;
        }
        return reverselist(dummy.next);
    }
    public ListNode reverselist(ListNode head){
        ListNode curr=head, prev=null;
        while(curr!=null){
            ListNode ahead=curr.next;
            curr.next=prev;
            prev=curr;
            curr=ahead;
        }
        return prev;
    }
}