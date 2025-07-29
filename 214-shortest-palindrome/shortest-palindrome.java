class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder sb=new StringBuilder(s);
        sb.reverse().toString();
        
        for(int i=0;i<s.length();i++){
    //to find the longest prefix that is equal to suffix of reverse string    
            if(s.substring(0,s.length()-i).equals(sb.substring(i))) 
                return new StringBuilder(sb.substring(0,i)).append(s).toString();
        }
        return "";
    }
}