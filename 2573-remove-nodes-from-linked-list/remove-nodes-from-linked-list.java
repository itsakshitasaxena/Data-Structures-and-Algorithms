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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> st=new Stack<>();
        ListNode temp=head;
        while(temp!=null){ //adding nodes to stack
            st.push(temp);
            
            temp=temp.next;
        }
        temp=st.pop();
        int max=temp.val;
        ListNode ans=new ListNode(max);

        while(!st.isEmpty()){
            temp=st.pop();
            if(temp.val<max)
                continue;
            else{
                ListNode ne=new ListNode(temp.val);
                ne.next=ans;
                ans=ne;
                max=temp.val;
            }
        }
        return ans;
    }
}