class Solution {
    public int minimumBuckets(String hamsters) {
        int ans=-1; // where last bucket is kept
        int bucket=0;
        for(int i=0;i<hamsters.length();i++){
            if(hamsters.charAt(i)=='H'){
                if(i-1>=0 && ans==i-1)  continue;
                if(i+1<hamsters.length() && hamsters.charAt(i+1)=='.'){
                    ans=i+1;
                    bucket++;
                }
                else if(i-1>=0 && hamsters.charAt(i-1)=='.')  bucket++;
                else return -1;
            }
        }
        return bucket;
    }
}