class Solution {
    public int maxOperations(String s) {
        int op=0, ones=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1')  ones++;
            else if(i>0&&s.charAt(i-1)=='0')  continue;
            else op+=ones;
        }
        return op;
        
    }
}