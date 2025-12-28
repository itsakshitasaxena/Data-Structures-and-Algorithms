class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        char first=pattern.charAt(0), last=pattern.charAt(1);
        long fc=0,lc=0,max=0,cnt=0;
        for(char t:text.toCharArray()){
            if(t==last)  max+=cnt;
            if(t==first)  cnt++;
        }
        for(char t:text.toCharArray()){
            if(t==first)  fc++;
            if(t==last)   lc++;
        }
        return max+Math.max(fc,lc);

    }
}