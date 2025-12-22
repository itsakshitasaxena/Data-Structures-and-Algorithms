class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int[] match=new int[s.length()];
        Arrays.fill(match,-1);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<indices.length;i++){
            int ind=indices[i];
            if(s.startsWith(sources[i], ind))   match[ind]=i;
        }
        for(int i=0;i<s.length();){
            if(match[i]!=-1){
                sb.append(targets[match[i]]);
                i+=sources[match[i]].length();
            }
            else{
                sb.append(s.charAt(i));
                i++; } 
        }
        return sb.toString();
    }
}