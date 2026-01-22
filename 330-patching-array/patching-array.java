class Solution {
    public int minPatches(int[] nums, int n) {
        long sum=0;
        int patch=0, i=0;
        while(sum<n){
            // if curr no. helps in extending sum
            if(i<nums.length && nums[i]<=sum+1){ 
                sum+=nums[i]; //extend sum
                i++;
            }
            else{  // Otherwise, patch the missing no. i.e. (sum + 1)
                sum+=(sum+1); // patch gives max expansion( in 2nd ex- 2)
                patch++;
            }
        }
        return patch;
    }
}