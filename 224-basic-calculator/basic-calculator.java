class Solution {
    public int calculate(String s) {
        int ans=0, num=0, sign=1;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                int n=s.charAt(i)-'0';
                num=num*10+n;
            }
            else if(s.charAt(i)=='+'){
                ans+=(num*sign);
                num=0;
                sign=1;
            }
            else if(s.charAt(i)=='-'){
                ans+=(num*sign);
                num=0;
                sign=-1;
            }
            else if(s.charAt(i)=='('){
                st.push(ans);
                st.push(sign);
                ans=0;
                num=0;
                sign=1;
            }
            else if(s.charAt(i)==')'){
                //ans of inner brackets
                ans+=(num*sign);
                num=0;
                ans*=st.pop();
                ans+=st.pop();

            }
        }
        ans+=(num*sign);
        return ans;
    }
}