class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long ans=0,total_diff=0;
        int[] diff=new int[100001]; //frequency  array of diff
        int max=0;
        for(int i=0;i<nums1.length;i++){
            int x=Math.abs(nums1[i]-nums2[i]);
            diff[x]++;
            total_diff+=x;
            max=Math.max(max,x); //max diff
        }
        k1+=k2; //total ops
        if(total_diff<=k1)  return 0;//if total diff<=k1 means we can make diff 0
        
        for(int d=max;d>0 && k1>0;d--){ // Greedily reduce the largest diff first

            if (diff[d] == 0) continue; // If there are no diff of value d, skip

            long reduce = Math.min(diff[d], k1); //No of ele reduce at this level

            // Reduce d -> d-1
            diff[d] -= reduce;
            diff[d - 1] += reduce;

            k1 -= reduce; // Use operations
        }
        for(int i=max;i>0;i--){
            ans+=(diff[i])*(long)i*i;
        }
        return ans; //tc-O(n + maxDiff)
    }
}