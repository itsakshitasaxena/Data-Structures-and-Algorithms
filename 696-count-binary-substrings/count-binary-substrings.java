class Solution {
    public int countBinarySubstrings(String s) {
        int c=0,curr=1,prev=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1))  curr++;
            else{
                c+=Math.min(prev,curr);
                prev=curr;
                curr=1;
            }
        }
        c+=Math.min(prev,curr);
        return c;
    }
}