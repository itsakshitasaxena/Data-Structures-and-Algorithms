/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> qu=new LinkedList<>();
        int width=0;
        qu.add(new Pair(root,0));
        while(!qu.isEmpty()){
            Pair start=qu.peek();
            Pair end=null;
            int size=qu.size();
            for(int i=0;i<size;i++){
                end=qu.poll();
                if(end.node.left!=null){
                    qu.add(new Pair(end.node.left, 2*end.idx+1));
                }
                if(end.node.right!=null){
                    qu.add(new Pair(end.node.right, 2*end.idx+2));
                }
            }
            width=Math.max(width, end.idx-start.idx+1);
        }
        return width;

    }

    class Pair{
        TreeNode node;
        int idx;
        public Pair(TreeNode node, int idx){
            this.idx=idx;
            this.node=node;
        }
    }
}