class Solution {
    public String minWindow(String s, String t) {
        int[] map=new int[256];
        for(char ch:t.toCharArray())
             map[ch]++;
        int i=0,l=0, r=0, cnt=0, ind=-1, minlen=Integer.MAX_VALUE, end=0;
        char[] st=s.toCharArray();
        while(r<st.length){
            if(map[st[r]]>0)   cnt+=1;
            map[st[r]]--;

            while(cnt==t.length()){
                if(r-l+1<minlen){
                    minlen=r-l+1;
                    ind=l;
                    end=r+1;
                }
                map[st[l]]++;
                if(map[st[l]]>0)   cnt-=1;
                l++;
            }
            r+=1;
        }
        return ind==-1?"":s.substring(ind,end);
    }
}