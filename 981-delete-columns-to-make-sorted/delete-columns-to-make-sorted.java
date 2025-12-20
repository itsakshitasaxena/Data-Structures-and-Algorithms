class Solution {
    public int minDeletionSize(String[] strs) {
        int cnt=0,n=strs.length,m=strs[0].length();
        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){
                if(strs[j].charAt(i)<strs[j-1].charAt(i)){
                    cnt++;break;
                }
            }
        }
        return cnt;
    }
}