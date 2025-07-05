class Solution {
    public int evalRPN(String[] tokens) {
        int n1=0, n2=0;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            
            if(tokens[i].equals("+")){
                n1=st.pop();
                n2=st.pop();
                st.push(n1+n2);
            }
            else if(tokens[i].equals("-")){
                n1=st.pop();
                n2=st.pop();
                st.push(n2-n1);
            }
            else if(tokens[i].equals("*")){
                n1=st.pop();
                n2=st.pop();
                st.push(n1*n2);
            }
            else if(tokens[i].equals("/")){
                n1=st.pop();
                n2=st.pop();
                st.push(n2/n1);
            }
            else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.peek();
    }
}