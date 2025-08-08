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
    List<Integer> prev=new ArrayList<>();
    public boolean isEvenOddTree(TreeNode root) {
        if(root==null)   return true;
        TreeNode curr=root;
        return dfs(curr,0);
    }

    public boolean dfs(TreeNode curr, int level){
        if(curr==null) //basecase
            return true;
        
        if(curr.val %2 ==level%2)
            return false;

        //add new level to prev if reached a new level
        while(prev.size()<=level)
            prev.add(0);

        //on even level->curr's value is greater than previous on this level
        //on odd level->curr's value is less than previous on this level

        if(prev.get(level)!=0 && ((level%2==0 && curr.val<=prev.get(level)) || (level %2==1 && curr.val>=prev.get(level))))
            return false;

        //add current value to prev at index level
        prev.set(level, curr.val);

        return dfs(curr.left, level+1) && dfs(curr.right,level+1);
    }
}