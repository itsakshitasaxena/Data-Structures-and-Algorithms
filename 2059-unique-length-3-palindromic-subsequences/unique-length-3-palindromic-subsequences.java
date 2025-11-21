class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] first=new int[26];
        int[] last=new int[26];
        Arrays.fill(first,-1);
        Arrays.fill(last,-1);
        //getting first&last occurence of every character
        for(int i=0;i<s.length();i++){
            int ch=s.charAt(i)-'a';
            if(first[ch]==-1) first[ch]=i;
            last[ch]=i;
        }
        int  cnt=0;
        for(int i=0;i<26;i++){
             // Character must appear at least twice: c _ c
            if(first[i]!=-1 && last[i]!=-1 && first[i]<last[i]){
                HashSet<Character> set=new HashSet<>();//to track unique middle characters
                for(int j=first[i]+1;j<last[i];j++){
                    set.add(s.charAt(j));
                }
                cnt+=set.size();
            }
        }
        return cnt;
    }
}