class Solution {
    public String simplifyPath(String path) {
        Stack<String> st=new Stack<>();
        String[] comp=path.split("/");
        for(String str:comp)
            System.out.print(str);
        for(String str:comp){
            if(str.equals(".") || str.equals(""))
                continue;
            if(str.equals("..")){
                if(!st.isEmpty())
                    st.pop();
            }
            else{
                st.push(str);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.insert(0, "/"+st.pop());
        }
        return sb.length()==0?"/":sb.toString();
    }
}