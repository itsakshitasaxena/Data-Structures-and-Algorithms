class Solution {
    public int binaryGap(int n) {
        int max=0, prev=-1, i=0;
        while(n>0){
            if((n&1)==1){
                if(prev!=-1) max=Math.max(max, i-prev);
                prev=i;
            }
            n>>=1;
            i++;
        }
        return max;
    }
}