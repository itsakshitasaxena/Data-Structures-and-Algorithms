class Solution {
    public int countSubstrings(String s) {
         return palindrome(s);
    }
    public int palindrome(String st){
        //for odd length
        int odd=0;
        for(int i=0;i<st.length();i++){
            for(int j=0;i-j>=0 && i+j<st.length();j++){
                if(st.charAt(i-j)!=st.charAt(i+j)) break;
                odd++;
            }
        }
        //for even length 
        int even=0;
        for(double i=0.5;i<st.length();i++){
            for(double j=0.5;i-j>=0 && i+j<st.length();j++){
                if(st.charAt((int)(i-j))!=st.charAt((int)(i+j))) break;
                even++;
            }
        }
        return odd+even;
    }
}