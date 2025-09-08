/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String serialize(TreeNode root) {
        if(root==null)       return "";
        StringBuilder res=new StringBuilder();
        // Queue<TreeNode> qu=new LinkedList<>();
        // qu.add(root);
        // while(!qu.isEmpty()){
        //     TreeNode node=qu.poll();
        //     if(node==null){
        //         res.append("null,");
        //         continue;
        //     }
        //     res.append(node.val).append(",");
        //     qu.add(node.left);
        //     qu.add(node.right);
        // }
        build(root, res);
        return res.toString();
    }
    public void build(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        build(root.left, sb);
        build(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="")  return null;

        String[] ar=data.split(",");
        return parse(ar);
    }
    int idx=0;
    public  TreeNode parse(String[] ar){
        if(idx>=ar.length)    return null;
        String st=ar[idx++];
        if(st.equals("null"))    return null;

        TreeNode node=new TreeNode(Integer.parseInt(st));
        node.left=parse(ar);
        node.right=parse(ar);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));