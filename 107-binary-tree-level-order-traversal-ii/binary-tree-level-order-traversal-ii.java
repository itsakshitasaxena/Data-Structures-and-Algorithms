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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> qu=new LinkedList<>();
        qu.add(root);
        while(!qu.isEmpty()){
            int size=qu.size();
            List<Integer> lst=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode pq=qu.poll();
                lst.add(pq.val);
                if(pq.left!=null)   qu.add(pq.left);
                if(pq.right!=null)  qu.add(pq.right);
            }
            ans.add(lst);
        }
        List<List<Integer>> res=new ArrayList<>();
        for(int i=ans.size()-1;i>=0;i--)
            res.add(ans.get(i));
        return res;
    }
}