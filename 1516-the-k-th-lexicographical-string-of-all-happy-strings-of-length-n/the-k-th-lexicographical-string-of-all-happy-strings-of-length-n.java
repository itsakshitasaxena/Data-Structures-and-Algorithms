class Solution {
    public String getHappyString(int n, int k) {
        ArrayList<String> lst=new ArrayList<>();
        FindHappyStrings("",lst, n, 0);
        return  k<=lst.size() ? lst.get(k-1) : "";
    }
    public static void FindHappyStrings(String st, ArrayList lst, int n, int ind){
        if(ind>=2&&st.charAt(ind-1)==st.charAt(ind-2))  return;
        if(st.length()==n){
            lst.add(st);
            return;
        }
        FindHappyStrings(st+'a',lst,n,ind+1);
        FindHappyStrings(st+'b',lst,n,ind+1);
        FindHappyStrings(st+'c',lst,n,ind+1);
    }
}