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
        k-=1; //Decrement k as we already start from the 1st node
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
            if(kth_node==null){ //(not a complete group)
                if(prev!=null)   
                    prev.next=temp; //link the last node to the current node
                break;
            }

            ListNode nextnode=kth_node.next;
            kth_node.next=null; //Disconnect the kth node
            reverse(temp);

            if(temp==head)  head=kth_node;
            else   
                prev.next=kth_node; //Link the last node of the previous
                // group to the reversed group

            prev=temp; // Update the pointer to the last node of the previous group
            temp=nextnode; //  Move to the next group
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