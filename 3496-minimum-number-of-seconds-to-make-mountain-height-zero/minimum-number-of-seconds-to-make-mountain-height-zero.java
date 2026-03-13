class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long lo=0, hi=(long)1e18;
        long ans=hi;
        while(lo<=hi){
            long mid=lo+(hi-lo)/2;
            if(ispossible(mid,mountainHeight,workerTimes )){
                ans=mid;
                hi=mid-1;
            }
            else lo=mid+1;
        }
        return ans;
    }
    public boolean ispossible(long mid, int height, int[] times){
        long reduced_height=0; // total mountain height reduced by all workers
        for(int t:times){
            long k=mid/t;
            long x=(long)((Math.sqrt(1+8.0*k)-1)/2); //maximum height this worker can reduce within 'time' 
            reduced_height+=x; //adding that worker's contri
            if(reduced_height>=height) return true; //stop if req. height is met
        }
        return false;
    }
}

// k = time / t
//worker time pattern -->  t + 2t + 3t + ... + xt = t(1 + 2 + 3 + ... + x)
// 1 + 2 + 3 + ... + x = x(x+1)/2  --> x(x+1)/2 ≤ k  --> x² + x ≤ 2k
// -->t * x(x+1)/2 ≤ time  -->  x(x+1)/2 ≤ time/t   so, k = time / t
// x² + x - 2k ≤ 0  --> x = (-1 + sqrt(1 + 8k)) / 2 //worker can reduce x height