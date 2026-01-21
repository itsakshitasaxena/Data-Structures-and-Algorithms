class Solution {
    public int largestVariance(String s) {
        int[] cnt=new int[26];
        for(char ch:s.toCharArray())    cnt[ch-'a']++;
        int ans=0;

        for(char i='a'; i<='z'; i++){
            for(char j='a';j<='z';j++){
                if(i==j || cnt[i-'a']==0 || cnt[j-'a']==0)   continue;
                boolean prev=false; // whether we dropped a j earlier
                int cnt1=0; // cnt of char i in curr window
                int cnt2=0; // cnt of char j in curr window
                for(char ch:s.toCharArray()){
                    if(i==ch)  cnt1++; 
                    if(j==ch)  cnt2++; 
                    if(cnt2>0) // Valid substring must contain at least one j
                        ans=Math.max(ans,cnt1-cnt2);
                    else if(prev){
                     // Special handling: if j not seen yet but was dropped earlier
                        
                         ans=Math.max(ans, cnt1-1);
                    }
                    if(cnt2>cnt1){ //Kadane’s algo:j becomes dominant, reset window
                        cnt1=0;
                        cnt2=0;
                        prev=true; //dropping j
                    }
                }
            }
        }
        return ans;
    }
}