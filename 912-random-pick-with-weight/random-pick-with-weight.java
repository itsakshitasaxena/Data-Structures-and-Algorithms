class Solution {
    int[] pref;
    int total=0;
    Random rand;
    public Solution(int[] w) {
        pref=new int[w.length];
        int sum=0;
        rand=new Random();
        for(int i=0;i<w.length;i++){
            sum+=w[i];
            pref[i]=sum;
        }
        total=sum;
    }
    
    public int pickIndex() {
        int lo=0,hi=pref.length-1,ans=0;
        int target=rand.nextInt(total)+1; //gives a number in [0, total-1] Adding +1 shifts it to [1, total].
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(pref[mid]<target) lo=mid+1;
            else hi=mid-1;
        }
        return lo;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */