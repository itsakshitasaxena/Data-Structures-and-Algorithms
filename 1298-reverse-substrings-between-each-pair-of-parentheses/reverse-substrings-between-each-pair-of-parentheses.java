class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st=new Stack<>();
        // StringBuilder sb=new StringBuilder();

        for(int i=0;i<s.length();i++){

            if(s.charAt(i)==')'){
                StringBuilder sb=new StringBuilder();
               while(!st.isEmpty() && st.peek()!='('){
                    sb.append(st.pop());
               }
               if(!st.isEmpty())   st.pop();
                for(char ch: sb.toString().toCharArray())
                        st.push(ch);

            }

            else{
                st.push(s.charAt(i));
            }
        }
        // sb.reverse();
        StringBuilder rev=new StringBuilder(st.size());
        while(!st.isEmpty()){
            rev.append(st.pop());
        }
        return rev.reverse().toString();
    }
}