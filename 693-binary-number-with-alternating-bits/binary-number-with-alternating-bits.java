class Solution {
    public boolean hasAlternatingBits(int n) {
        String st=Integer.toBinaryString(n);
        for(int i=1;i<st.length();i++)
            if(st.charAt(i)==st.charAt(i-1))   return false;
        return true;
    }
}