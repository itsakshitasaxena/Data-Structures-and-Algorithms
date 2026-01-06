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
    public int maxLevelSum(TreeNode root) {
        int max=Integer.MIN_VALUE,anslevel=1,level=1;
        Queue<TreeNode> qu=new LinkedList<>();
        qu.add(root);
        while(!qu.isEmpty()){
            
            int sum=0;
            int size=qu.size();
            for(int i=0;i<size;i++){
                TreeNode node=qu.poll();
                sum+=node.val;
                if(node.left!=null) qu.add(node.left);
                if(node.right!=null)  qu.add(node.right);
            }
            if(sum>max){
                max=sum;
                anslevel=level;
            }
            level++;
        }
        return anslevel;


    }
}