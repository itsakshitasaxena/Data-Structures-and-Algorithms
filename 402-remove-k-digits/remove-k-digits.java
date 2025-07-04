class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()<=k)   return "0";

        //keep smaller digits at the start
        //get rid of the k larger ones

        Stack<Character> st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<num.length();i++){
            char ch=num.charAt(i);
            while(!st.isEmpty() && k>0 && st.peek()-'0'>ch-'0'){
                st.pop();
                k-=1;
            }
            st.push(ch);
        }
        while(k>0 && !st.isEmpty()){
            st.pop(); k--; //remove remaining bigger elements
        }

        if(st.isEmpty())   return "0";

        while(!st.isEmpty()){
            sb.append(st.peek());
            st.pop();
        }
        sb.reverse();
        while(sb.length()!=0 && sb.charAt(0)=='0')
            sb.deleteCharAt(0); //removing all leading zeroes
        
        if(sb.length()==0)   return "0";

        return sb.toString();
    }
}