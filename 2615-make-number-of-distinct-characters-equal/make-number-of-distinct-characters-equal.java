class Solution {
    public boolean isItPossible(String word1, String word2) {
        int[] fr1=new int[26];
        int[] fr2=new int[26];
        int dist1=0, dist2=0;
        for(char ch:word1.toCharArray())
            fr1[ch-'a']++;
        for(char ch:word2.toCharArray())
            fr2[ch-'a']++;
        for(int i=0;i<26;i++){
            if(fr1[i]>0)  dist1++;
            if(fr2[i]>0)  dist2++;
        }
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                if(fr1[i]==0||fr2[j]==0) continue;
                if(i==j){
                    if(dist1==dist2) return true;
                    continue;
                }

                int d1=dist1, d2=dist2; //di
                if(fr1[i]==1)  d1--;  // remove i from word1
                if(fr1[j]==0)  d1++; // add j to word1
                if(fr2[j]==1)  d2--; // remove j from word2
                if(fr2[i]==0)  d2++;  // add i to word2

                if(d1==d2) return true;
            }
        }
        return false;
    }
}