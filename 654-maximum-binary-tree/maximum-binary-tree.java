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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return maxbintree(0,nums.length,nums);
    }
    public TreeNode maxbintree(int st, int end, int[]nums){
        if(st>=end)   return null;
        //divide and conquer--> divide by max value everytime
        int maxind=maxIndex(st,end,nums);
        //creating tree root by maxind
        TreeNode root=new TreeNode(nums[maxind]);
 
        //left--> start to maxind; right-->maxind to end
        root.left=maxbintree(st,maxind,nums);
        root.right=maxbintree(maxind+1,end,nums);

        return root;
        
    }

    public int maxIndex(int start, int end, int[]nums){
        int maxind=start;
        for(int i=start;i<end;i++){
            if(nums[maxind]<nums[i])    
                maxind=i; //getting index of new max element everytime
        }
        return maxind;
    }
}