class Solution {
    public int maximumSum(int[] arr) {
        int n=arr.length;
        int[] pref=new int[n];
        int[] suff=new int[n];
        int ans=arr[0]; pref[0]=arr[0]; suff[n-1]=arr[n-1];
        for(int i=1;i<n;i++){
            pref[i]=Math.max(arr[i], arr[i]+pref[i-1]);
            ans=Math.max(ans, pref[i]);
        }
        for(int i=n-2;i>=0;i--)
            suff[i]=Math.max(suff[i+1]+arr[i], arr[i]);
        for(int i=1;i<n-1;i++){
            ans=Math.max(ans, pref[i-1]+suff[i+1]);
        }
        return ans;

    }
}