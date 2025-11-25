class Solution {
    public int smallestRepunitDivByK(int k) {
        int rem=0;
        for(int n=1;n<=k;n++){
            rem=(rem*10+1)%k;
            if(rem==0)
                return n;
        }
        return -1;
    }
}