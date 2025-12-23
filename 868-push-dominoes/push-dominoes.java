class Solution {
    public String pushDominoes(String dominoes) {
        StringBuilder sb=new StringBuilder();
        int force=0, n=dominoes.length();
        int[] push=new int[n];
        //forward pushing dominoes
        for(int i=0;i<n;i++){
            if(dominoes.charAt(i)=='R')  force=n;
            else if(dominoes.charAt(i)=='L')  force=0;
            else force=Math.max(force-1,0);
            push[i]+=force;
        }
        //backward pushing dominoes
        for(int i=n-1;i>=0;i--){
            if(dominoes.charAt(i)=='R') force=0;
            else if(dominoes.charAt(i)=='L')  force=n;
            else force=Math.max(force-1,0);
            push[i]-=force;
        }
        //building string at final state
        for(int i=0;i<n;i++){
            if(push[i]>0)   sb.append('R');
            else if(push[i]<0)  sb.append('L');
            else sb.append('.');
        }
        return sb.toString();
    }
}