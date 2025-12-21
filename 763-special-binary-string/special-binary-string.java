class Solution {
    public String makeLargestSpecial(String s) {
        String ans="";
        List<String> lst=new ArrayList<>();
        int cnt=0,i=0;
        for(int j=0;j<s.length();j++){
            if(s.charAt(j)=='1')  cnt++;
            else cnt--;
            if(cnt==0){ // if cnt of 0&1 equal then add 0&1 as outer
                lst.add("1"+makeLargestSpecial(s.substring(i+1,j))+"0");
                i=j+1;
            }
        }
        Collections.sort(lst,Collections.reverseOrder());
        for(String a:lst) ans+=a;
        return ans;
    }
}