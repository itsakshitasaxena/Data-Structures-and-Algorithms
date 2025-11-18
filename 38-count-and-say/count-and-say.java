class Solution {
    public String countAndSay(int n) {
        String ans="1";
        for(int i=1;i<n;i++){
            ans=say(ans);
        }
        return ans;
    }
    public String say(String st){
        StringBuilder sb=new StringBuilder();
        int cnt=1;
        for(int i=1;i<st.length();i++){
            if(st.charAt(i)==st.charAt(i-1)){
                cnt++;
            }
            else{
                sb.append(cnt).append(st.charAt(i-1));
                cnt=1;
            }
        }
        sb.append(cnt).append(st.charAt(st.length()-1));
        return sb.toString();
    }
}