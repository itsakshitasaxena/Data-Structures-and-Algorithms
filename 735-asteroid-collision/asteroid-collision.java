class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]>0)   st.push(asteroids[i]);
            else{
                //destroying only opposite asteroids or less asteroids
                while(!st.isEmpty() && st.peek()>0 && st.peek()<Math.abs(asteroids[i]))
                    st.pop();
                if(!st.isEmpty() && st.peek()==Math.abs(asteroids[i]))
                    st.pop();
                else if(st.isEmpty() || st.peek()<0) // adding-ve only if stack is empty or has -ve elements
                    st.push(asteroids[i]);
            }
        }
        int[] ans=new int[st.size()];
        for(int i=st.size()-1;i>=0;i--){
            ans[i]=st.pop();
        }
        return ans;
    }
}