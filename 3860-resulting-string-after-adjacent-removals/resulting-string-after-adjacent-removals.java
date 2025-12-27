class Solution {
    public String resultingString(String s) {
        StringBuilder sb=new StringBuilder();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!st.isEmpty()&&is_consecutive(st.peek(), s.charAt(i)))
                st.pop();
            else st.push(s.charAt(i));
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
    public boolean is_consecutive(char c1, char c2){
        if(c1-c2==1||c1-c2==-1)  return true;
        if(c1=='a' && c2=='z')   return true;
        if(c1=='z' && c2=='a')   return true;
        return false;
    }
}