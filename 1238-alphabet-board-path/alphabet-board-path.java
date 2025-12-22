class Solution {
    // String[] board = {"abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"}; //ejoty
    StringBuilder sb;
    public String alphabetBoardPath(String target) {
        sb=new StringBuilder();
        path(target,0,0);
        return sb.toString();
    }
    public void path(String goal, int i, int j){
        if(goal.length()==0)   return;
        char ch=goal.charAt(0);
        int r=(ch-'a')/5;
        int c=(ch-'a')%5;
        while(c<j){
            sb.append("L");
            j--;
        }
        while(r>i){
            sb.append("D");
            i++;
        }
        while(r<i){
            sb.append("U");
            i--;
        }
        while(c>j){
            sb.append("R");
            j++;
        }
        sb.append("!");
        path(goal.substring(1),r,c);
    }
}