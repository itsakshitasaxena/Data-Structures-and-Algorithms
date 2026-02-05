class Solution {
     static List<String> ans;
    public List<String> findWords(char[][] board, String[] words) {
        ans=new ArrayList<>();
        Trie t=new Trie();
        for(String s:words){
            t.insert(s);
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                //call lagegi for maze[i][j] uske root m chia ka hona jruri h
                if(t.root.child.containsKey(board[i][j])){
                    t.search(board,i,j,t.root);
                }
            }
        }
        return ans;
    }
   
     static class Trie{
        class Node{
        char ch;
        String  isterminal;
        HashMap<Character, Node> child;
            public Node(char ch){
                this.ch=ch;
                child=new HashMap<>();
            }
        }
        private Node root;
        public Trie() {
            root=new Node('*');
        } 
        public void insert(String word){
            Node curr=root;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(curr.child.containsKey(ch)){
                    curr=curr.child.get(ch);
                }
                else{
                    Node nn=new Node(ch);
                    curr.child.put(ch,nn);
                    curr=nn;
                }
            }
            curr.isterminal=word;
        }
        public void search(char[][] maze, int i, int j, Node node){
            if(i<0||j<0||i>=maze.length || j>=maze[0].length || !node.child.containsKey(maze[i][j])) return;
            char ch=maze[i][j];
            node=node.child.get(ch);
            if(node.isterminal!=null){
                ans.add(node.isterminal);
                node.isterminal=null; //to avoid duplicate entry in ans

            }
            maze[i][j]='$'; //marking vis
            search(maze,i+1,j,node);
            search(maze,i-1,j,node);
            search(maze,i,j+1,node);
            search(maze,i,j-1,node);
            maze[i][j]=ch; //unmarking vis

        }
    }
}