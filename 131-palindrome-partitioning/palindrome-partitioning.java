class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> ll=new ArrayList<>();
        partition(ans,ll,s,"");
        return ans;
    }
    public void partition(List<List<String>> ans, List<String> ll, String ques, String st){
        if(ques.length()==0){
            ans.add(new ArrayList<>(ll));
            return;
        }
        for(int cut=1;cut<=ques.length();cut++){
            String sub=ques.substring(0,cut);
            if(ispalindrome(sub)){
                ll.add(sub);
                partition(ans,ll,ques.substring(cut),st+sub);
                ll.remove(ll.size()-1);
            }
        }
    }
    public boolean ispalindrome(String st){
        int i=0, j=st.length()-1;
        while(i<=j){
            if(st.charAt(i)!=st.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
}