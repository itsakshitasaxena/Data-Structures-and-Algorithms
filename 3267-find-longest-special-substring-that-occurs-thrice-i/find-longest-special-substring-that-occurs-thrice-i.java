class Solution {
    public int maximumLength(String s) {
        HashMap<String, Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            StringBuilder curr=new StringBuilder();
            for(int j=i;j<s.length();j++){
                if(curr.length()==0 || curr.charAt(curr.length()-1)==s.charAt(j)){
                    curr.append(s.charAt(j));
                    map.put(curr.toString(), map.getOrDefault(curr.toString(), 0)+1);
                }
                else  break;
            }
        }
        int ans=0; //to store the longest len of substring with fr atleast 3
        for(String st:map.keySet()){
            if(map.get(st)>=3 && st.length()>ans)// longest & fr(ch) >=3
                 ans=st.length();
        }
        return ans==0 ? -1 : ans;
    }
}