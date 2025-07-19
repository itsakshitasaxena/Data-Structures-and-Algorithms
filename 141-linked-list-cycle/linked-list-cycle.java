/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow=head, fast=head;
        // Tortoise&Hare Algo is used here like in middle of ll
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                return true; //if there is a loop they will always collide as the distance b/w slow n fast is d and ts decreasing by 1 at every iteration  (d%1==0)
        }
        return false;
    }
}