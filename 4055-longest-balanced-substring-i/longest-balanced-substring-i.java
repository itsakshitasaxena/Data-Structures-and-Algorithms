class Solution {
    public int longestBalanced(String s) {
        int len=0;
        for(int i=0;i<s.length();i++){
            int[] fr=new int[26];
            for(int j=i;j<s.length();j++){
               fr[s.charAt(j)-'a']++;
               int min=Integer.MAX_VALUE, max=0;
               for(int k=0;k<26;k++){
                    if(fr[k]>0){
                        min=Math.min(min, fr[k]);
                        max=Math.max(max,fr[k]);
                    }
               }
               if(min==max) len=Math.max(len, j-i+1);
            }   

        }
        return len;
    }
}