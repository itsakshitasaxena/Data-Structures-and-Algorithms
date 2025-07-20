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
    public ListNode get_kthnode(ListNode temp, int k){
        k-=1;
        while(temp!=null && k>0){
            k--;
            temp=temp.next;
        }
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head, prev=null;
        while(temp!=null){
            ListNode kth_node=get_kthnode(temp, k); //everytime get starting point of group
            if(kth_node==null){
                if(prev!=null)   prev.next=temp;
                break;
            }

            ListNode nextnode=kth_node.next;
            kth_node.next=null;
            reverse(temp);

            if(temp==head)  head=kth_node;
            else   prev.next=kth_node;

            prev=temp;
            temp=nextnode;
        }
        return head;
    }
    public ListNode reverse(ListNode head){
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