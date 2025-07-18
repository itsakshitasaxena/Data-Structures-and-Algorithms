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
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode temp=head;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }

        while(head!=null && set.contains(head.val))
            head=head.next; //if head value is present in set , remove it

        if(head==null)   return null; //in case if list is empty

        ListNode curr=head;
        while(curr.next!=null){
            if(set.contains(curr.next.val)){
                curr.next=curr.next.next;
            }
            else    curr=curr.next;
        }
        return head;
      
    }
}