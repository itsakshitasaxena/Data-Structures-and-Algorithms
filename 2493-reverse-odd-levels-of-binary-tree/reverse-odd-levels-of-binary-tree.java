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
    public TreeNode reverseOddLevels(TreeNode root) {
        int level=0;
        Queue<TreeNode> qu=new LinkedList<>();
        qu.add(root);
        while(!qu.isEmpty()){
            int size=qu.size();
            List<TreeNode> lst=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=qu.poll();
                lst.add(node);
                if(node.left!=null)  qu.add(node.left);
                if(node.right!=null) qu.add(node.right);
            }
            if(level%2!=0){
                int l=0, r=lst.size()-1;
                while(l<r){
                    int temp=lst.get(l).val;
                    lst.get(l).val=lst.get(r).val;
                    lst.get(r).val=temp;
                    l++;
                    r--;
                }
            }
            level++;
        }
        return root;
    }
}