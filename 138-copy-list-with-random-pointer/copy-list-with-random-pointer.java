/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        insertnodesbetween(head); //Insert copy of nodes in between
        copyrandom(head); // Connect random pointers of copied nodes
        return copynextpointers(head); //Retrieve the deep copy of the linked list
    }
    public void insertnodesbetween(Node head){
        Node temp=head;
        //Step1
        while(temp!=null){
            Node copynode=new Node(temp.val);
            copynode.next=temp.next;
            temp.next=copynode;
            temp=temp.next.next;
        }
    }
    public void copyrandom(Node head){
        //Step2--> copy random pointers
        Node temp=head;
        while(temp!=null){
            Node copynode=temp.next;
            if(temp.random!=null)
                copynode.random=temp.random.next;
            temp=temp.next.next;
        }
    }
    public Node copynextpointers(Node head){
        // Step3- copy next pointers
        Node temp=head;
        Node dummy=new Node(-1);
        Node res=dummy;
        while(temp!=null){
            res.next=temp.next;
            temp.next=temp.next.next;

            res=res.next;
            temp=temp.next;
        }
        return dummy.next;
    }
}