class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1)    return 1; //trust is empty in this case so necessary 
        int[] cnt=new int[n+1];
        for(int i=0;i<trust.length;i++){
            cnt[trust[i][0]]=-1; // trusting others disqualified hence -1
            cnt[trust[i][1]]++; //get trusted score increases
        }
        for(int i=0;i<cnt.length;i++){
            if(cnt[i]==n-1) return i;
        }
        return -1;
    }
}