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
        ListNode dummy=new ListNode (-1);
        ListNode curr=dummy;
        int carry=0;
        while(l1!=null || l2!=null){
            int sum=carry;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            ListNode  newnode=new ListNode (sum%10);
            carry=sum/10;

            curr.next=newnode;
            curr=curr.next;
        }
        if(carry!=0){
            ListNode  newnode=new ListNode (carry);
            curr.next=newnode;
        }
        return dummy.next;
    }
}



//*Adding one to the ll number
// carry=add_helper(head);
// if(carry==1){
//     LinkedNode newnode= new LinkedNode(1);
//     newnode.next=head;
//     return newnode;
// }
// return head;
// public static int add_helper(LinkedNode head){
//     LinkedNode temp=head;
//     if(temp==null) 
//         return 1;
//     carry=helper(head.next);
//     temp.val+=carry;
//     if(temp.val<10){
//         return 0;
//     }
//     temp.val=0;
//     return 1;
// }
//TC-O(N), SC-O(N)