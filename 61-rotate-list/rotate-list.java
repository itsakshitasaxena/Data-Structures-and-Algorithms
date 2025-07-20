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
    // public ListNode findnode(ListNode temp, int k){
    //     int cnt=1;
    //     while(temp.next!=null){
    //         if(cnt==k)  return temp;
    //         cnt++;
    //         temp=temp.next;
    //     }
    //     return temp;
    // }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0)   return head;
        int len=1;
        ListNode tail=head;
        while(tail.next!=null){
            len++;
            tail=tail.next;
        }
        if(k%len==0)   return head;
        k=k%len;

        tail.next=head; //attaching tail to head
        // ListNode newNode=findnode(head, len-k);
        int t=len-k;
        while(t--!=0)   tail=tail.next;
        head=tail.next;
        tail.next=null;

        return head;

    }
}