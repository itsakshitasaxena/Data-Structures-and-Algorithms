class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length<3)  return false;

        Stack<Integer> st=new Stack<>();
        int sec=Integer.MIN_VALUE;
        
        for(int i=nums.length-1;i>=0;i--){
            if(sec>nums[i])   return true;
        //popping while current number is bigger than stack top
            while(!st.isEmpty() && nums[i]>st.peek())
                sec=st.pop();
            st.push(nums[i]);
        }
        return false;
    }
}