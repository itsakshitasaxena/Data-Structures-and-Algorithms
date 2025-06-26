class Solution {
    public List<List<String>> partition(String s) {
        List<String> ll = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        partition(s,"", ll, res);
        return res;
    }
    public static void partition(String ques, String ans, List<String> ll, List<List<String>> res)
    { 
        if(ques.length()==0)
        {
            res.add(new ArrayList(ll));
                // System.out.println(ans);
                // return;
            return;
        }
        for(int cut=1;cut<=ques.length();cut++){
            String s=ques.substring(0,cut);
            if(ispalindrome(s))
            {
                ll.add(s);
                partition(ques.substring(cut), ans+s+"|",ll,res);
                ll.remove(ll.size()-1);
            }
        }

    }
    public static boolean ispalindrome(String st){
        int i=0,j=st.length()-1;
        while(i<j)
        {
            if(st.charAt(i)!=st.charAt(j))
              return false;
            i++;
            j--;
        }
        return true;
    }
}