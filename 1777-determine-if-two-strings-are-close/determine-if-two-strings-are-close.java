class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] fr1=new int[26];
        int[] fr2=new int[26];
        for(char c:word1.toCharArray())  fr1[c-'a']++;
        for(char c:word2.toCharArray())  fr2[c-'a']++;
        for(int i=0;i<26;i++){
            if((fr1[i]==0&&fr2[i]!=0)||(fr1[i]!=0&&fr2[i]==0))
                return false;
        }   
        Arrays.sort(fr1);
        Arrays.sort(fr2);
        return Arrays.equals(fr1,fr2);
    }
}