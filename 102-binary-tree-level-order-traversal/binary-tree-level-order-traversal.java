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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)  return ans; 
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> lst=new ArrayList<>(); //list to store nodes at current level
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll(); //getting front node of level
                lst.add(node.val); //storing that node

                // enqueueing child nodes if exist
                if(node.left!=null)  queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            ans.add(lst);        
        }
        return ans;    
    }
}