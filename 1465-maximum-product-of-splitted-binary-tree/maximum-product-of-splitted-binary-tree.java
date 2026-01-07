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
    long ans=0;
    public int maxProduct(TreeNode root) {
        long total=dfs(root);
        Queue<TreeNode> qu=new LinkedList<>();
        qu.add(root);
        while(!qu.isEmpty()){
            TreeNode node=qu.poll();
            if(node==null)   continue;

            long curr=(total-node.val)*node.val;
            ans=Math.max(ans,curr);
            if(node.left!=null)   qu.add(node.left);
            if(node.right!=null)  qu.add(node.right);
        }
        return (int) (ans%1000000007);
    }
    public long dfs(TreeNode root){
        if(root==null)  return 0;
        root.val+=dfs(root.left)+dfs(root.right);
        return root.val;
    }
}