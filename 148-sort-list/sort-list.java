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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)    return head;

        ListNode mid=findmid(head);
        ListNode midnext=mid.next;
        mid.next=null;
        ListNode left=sortList(head);
        ListNode right=sortList(midnext); //mid+1
        return mergeLL(left, right);
    }
    public ListNode mergeLL(ListNode l1, ListNode l2){
        
        ListNode dummy=new ListNode(0);
        ListNode temp=dummy;

        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                temp.next=l1;
                temp=temp.next;
                l1=l1.next;
                
            }
            else{
                temp.next=l2;
                l2=l2.next;
                temp=temp.next;
            }
        }
        if(l1==null) 
            temp.next=l2;
        if(l2==null)
            temp.next=l1;

        return dummy.next;

    }
    public ListNode findmid(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next;//(this fast gives first middle)
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}

//TC-O(N)*(N+N/2)