class Solution {
    public long subArrayRanges(int[] nums) {
        int[] pse=new int[nums.length];
        int[] nse=new int[nums.length];
        int[] pge=new int[nums.length];
        int[] nge=new int[nums.length];
        long min_sum=0, max_sum=0;
        Stack<Integer> st=new Stack<>();

    //previous  smallest element 
        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty()&& nums[st.peek()]>nums[i])
                st.pop();
            pse[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }

        st.clear();

    // next  smallest element 
        for(int i=nums.length-1;i>=0;i--){
            while(!st.isEmpty()&& nums[st.peek()]>=nums[i])
                st.pop();
            nse[i]=st.isEmpty()?nums.length:st.peek();
            st.push(i);
        }

        st.clear();

    // previous greater element
        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i])
                st.pop();
            pge[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }

        st.clear();

    //next greater element
        for(int i=nums.length-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i])
                st.pop();
            nge[i]=st.isEmpty()?nums.length:st.peek();
            st.push(i);
        }
        st.clear();

    //Sum of subarray Minimums
        for(int i=0;i<nums.length;i++){
            long left=i-pse[i];
            long right=nse[i]-i;
            min_sum+=(left*right*nums[i]);
        }
    //Sum of subarray maximums
        for(int i=0;i<nums.length;i++){
            long left=i-pge[i];
            long right=nge[i]-i;
            max_sum+=(left*right*nums[i]);
        }
        return max_sum-min_sum;
    }
}