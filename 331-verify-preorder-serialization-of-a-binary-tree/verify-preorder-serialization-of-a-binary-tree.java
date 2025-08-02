class Solution {
    int it=0; //iterator
    // preorder traversal--> root left right 
    public boolean isValidSerialization(String preorder) {
        String[] st=preorder.split(",");

        // i condition to check tree finished but ele exists in string
        return constructTree(st) && it>=st.length-1;
    }
    public boolean constructTree(String[] st){
        //checking tree not finished but array is
        if(it>=st.length) return false;

        //checking leaf node
        if(st[it].equals("#")) return true;

        //checking left node
        it++;
        boolean x=constructTree(st);

        //checking right node
        it++;
        boolean y=constructTree(st);

        //checking for both coorect
        return x && y;

    }
}