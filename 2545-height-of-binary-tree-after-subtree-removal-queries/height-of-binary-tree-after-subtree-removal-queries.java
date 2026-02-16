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
     // maxheight[x] = height of tree after removing subtree rooted at x
    static final int[] maxheight=new int[100001];
    int currmax=0; //max depth seen so far
    public int[] treeQueries(TreeNode root, int[] queries) {
   // Each node’s answer depends on the maximum height outside its subtree from BOTH directions.
        lefttoright(root,0); // fresh height from other side too
        currmax=0;
        righttoleft(root,0);
        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++)
            ans[i]=maxheight[queries[i]];
        return ans;
    }
//taversing from both dir.n bcs if we see left then right side max depth would be missed or vice versa so using both side traversals 
    public void lefttoright(TreeNode root, int currheight){
        if(root==null) return;
        maxheight[root.val]=currmax; //store best height from prev branches
        currmax=Math.max(currmax, currheight); //update global maxdepth
        lefttoright(root.left,currheight+1);
        lefttoright(root.right,currheight+1);
    }
    public void righttoleft(TreeNode root, int currheight){
        if(root==null) return;
        maxheight[root.val]=Math.max(maxheight[root.val],currmax);//continue maxdepth and put the max height for this node
        currmax=Math.max(currmax,currheight);
        righttoleft(root.right,currheight+1);
        righttoleft(root.left,currheight+1);
    }
}