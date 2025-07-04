class Solution {
    public String removeStars(String s) {
        StringBuilder sb=new StringBuilder();
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='*'){
                if(!st.isEmpty() && Character.isLetter(st.peek()))
                    st.pop();
            }
            else{
                // ans+=st.peek();
                st.push(ch);
            }
        }
        for(int i=st.size()-1;i>=0;i--){
            sb.append(st.peek());
            st.pop();
        }
        return (sb.reverse()).toString();
    }
}