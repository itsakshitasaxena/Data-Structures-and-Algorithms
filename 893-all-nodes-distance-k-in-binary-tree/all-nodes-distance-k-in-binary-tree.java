/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> map=new HashMap<>();
        built_parent(root,null,map);

        Set<TreeNode> vis=new HashSet<>();
        Queue<TreeNode> qu=new LinkedList<>();

        vis.add(target);   
        qu.add(target);

        int dis=0;

        while(!qu.isEmpty()){
            if(dis==k)   break;

            int size=qu.size();
            for(int i=0;i<size;i++){
                TreeNode curr=qu.poll();

                if(curr.left!=null && !vis.contains(curr.left)){
                    vis.add(curr.left);
                    qu.add(curr.left);
                }
                if(curr.right!=null && !vis.contains(curr.right)){
                    vis.add(curr.right);
                    qu.add(curr.right);
                }

                TreeNode par=map.get(curr);
                if(par!=null && !vis.contains(par)){
                    vis.add(par);
                    qu.add(par);
                }
            }
            dis++;
        }
        List<Integer> ans=new ArrayList<>();
        while(!qu.isEmpty()){
            ans.add(qu.poll().val);
        
        }
        return ans;
    }

    public void built_parent(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> map){
        if(node==null)   return;

        if(parent!=null){
            map.put(node,parent);
        }
        built_parent(node.left,node,map);
        built_parent(node.right,node,map);
    }

}