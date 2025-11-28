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
    public ListNode insertionSortList(ListNode head) {
        List<Integer> lst=new ArrayList<>();
        while(head!=null){
            lst.add(head.val);
            head=head.next;
        }
        Collections.sort(lst);
        ListNode node=new ListNode(lst.get(0));
        ListNode temp=node;
        for(int i=1;i<lst.size();i++){
            ListNode neww=new ListNode(lst.get(i));
            temp.next=neww;
            temp=neww;
        }
        return node;
    }
}