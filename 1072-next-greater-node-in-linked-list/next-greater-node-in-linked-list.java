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
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> lst=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            lst.add(temp.val);
            temp=temp.next;
        }
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[lst.size()];
        for(int i=0;i<lst.size();i++){
            while(!st.isEmpty() && lst.get(st.peek())<lst.get(i)){
                ans[st.pop()]=lst.get(i);

            }
            st.push(i);
        }
        return ans;
    }
}