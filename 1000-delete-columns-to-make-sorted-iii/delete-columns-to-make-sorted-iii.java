class Solution {
    public int minDeletionSize(String[] strs) {
        int[] dp=new int[strs[0].length()];
        Arrays.fill(dp,1);
        int max=0;
        for(int i=0;i<strs[0].length();i++){
            for(int j=0;j<i;j++){
                boolean f=true;
                for(int k=0;k<strs.length;k++){
                    if(strs[k].charAt(j)>strs[k].charAt(i)){
                        f=false;break;
                    }
                }
                if(f)  dp[i]=Math.max(dp[i],dp[j]+1);

            }
            max=Math.max(max,dp[i]);
        }
        return strs[0].length()-max;
    }
}