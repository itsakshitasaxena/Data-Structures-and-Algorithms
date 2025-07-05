class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st=new Stack<>();
        int a=0;
        for(int i=0;i<pushed.length;i++){
            st.push(pushed[i]);

            while(!st.isEmpty() && st.peek()==popped[a]){
                a++;
                st.pop();
            }

        }
        
        return st.isEmpty();
    }
}