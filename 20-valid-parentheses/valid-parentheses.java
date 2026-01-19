class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            //pushing opening brackets   
            if(ch=='('||ch=='{'||ch=='[')   
                st.push(ch); 
            else{
                if(st.isEmpty())  return false;
                else{ //matching with closing brackets
                   char curr=st.pop();
                   if((ch==')' && curr!='(') || (ch==']' && curr!='[') || (ch=='}' && curr!='{')  )    return false;
                }
            }
        }
        return st.isEmpty();
    }
}