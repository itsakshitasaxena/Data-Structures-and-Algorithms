class Solution {
    public String removeSubstring(String s, int k) {
        StringBuilder ans = new StringBuilder(s);
        StringBuilder pat = new StringBuilder();
        for (int i = 0;i< k; i++) 
            pat.append('(');
        
        for (int i = 0; i < k; i++) 
            pat.append(')');
        
        String pattern = pat.toString();
        if(pattern.length()== 0) return s;

        int i = 0;
        while(i<=ans.length()-2*k){
            if(ans.substring(i,i+2*k).equals(pattern)){
                ans.delete(i,i+2*k);
                i = Math.max(0,i-2*k);
            }
            else i++;
        }
        return ans.toString();
    }
}