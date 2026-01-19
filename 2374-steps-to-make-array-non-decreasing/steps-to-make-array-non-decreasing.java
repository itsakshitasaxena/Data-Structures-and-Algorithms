class Solution {
    public int totalSteps(int[] nums) {
        Stack<int[]> st=new Stack<>(); //storing the value & no. of steps after which it gets removed
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int currsteps=0;
            while(!st.isEmpty() && st.peek()[0]<=nums[i]){
                currsteps=Math.max(currsteps, st.peek()[1]);
                st.pop();
            }
            if(st.isEmpty() )  currsteps=0;
            else currsteps+=1;
            max=Math.max(currsteps,max);
            st.push(new int[]{nums[i], currsteps});
        }
        return max;
    }
}