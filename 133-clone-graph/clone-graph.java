/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> map=new HashMap<>();
    //map keeps track of the old address-->new address 
    public Node cloneGraph(Node node) {
        if(node==null)  return node;
        if(map.containsKey(node)) 
            return map.get(node);
        Node neww=new Node(node.val);
        map.put(node, neww);

        for(Node nn:node.neighbors)
            neww.neighbors.add(cloneGraph(nn));

        return neww;
    }
}