class LRUCache {

    int capacity;
    HashMap<Integer, Node> map;
    Node head=new Node(0,0), tail=new Node(0,0);

    public LRUCache(int capacity) {
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head; 
        map=new HashMap<>(); 
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            remove(node); //remove &
            insert(node); //place at the front
            return node.value;
        }
        else
            return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size()==capacity)  
            remove(tail.prev);
        insert(new Node(key, value));
    }
    public void remove(Node node){
        // if(node==null || node.prev==null || node.next==null)   return ;
        map.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    public void insert(Node node){
        map.put(node.key, node);
        node.next=head.next;
        node.next.prev=node;
        head.next=node;
        node.prev=head;
    }
    class Node{
        int key, value;
        Node next, prev;
        Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }
}

// /**
//  * Your LRUCache object will be instantiated and called as such:
//  * LRUCache obj = new LRUCache(capacity);
//  * int param_1 = obj.get(key);
//  * obj.put(key,value);
//  */


