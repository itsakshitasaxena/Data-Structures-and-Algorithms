class Solution {
    public int[] sumZero(int n) {
        int[] ans=new int[n];
        int i=0,a=1;
        if(n%2!=0)
            ans[i++]=0;
        boolean f=true;
        while(i<n){
            ans[i++]=f?a:(0-a);
            f=!f;
            if(f)    a++;
        }
        return ans;
    }
}