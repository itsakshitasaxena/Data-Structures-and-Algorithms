class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        long sum=((long)k*(k+1)/2); 
        int prev=0;
        for(int ele:nums){
            if(prev==ele)  continue; //ignoring duplicates
            if(ele<=k){
                sum-=ele; //remove blocked no. (as already used)
                sum+=(++k); //increasing k for adding next available no. i.e. (++k)
            }
            prev=ele;
        }
        return sum;
    }
}