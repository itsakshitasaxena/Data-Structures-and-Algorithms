class Solution {
    public String longestNiceSubstring(String s) {
        String ans="";
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String sub=s.substring(i,j+1);
                if(nice(sub)&&(sub.length()>ans.length())) ans=sub;
                
            }
        }
        return ans;
    }
    public boolean nice(String sub){
        HashSet<Character> set=new HashSet<>();
        for(char c:sub.toCharArray())   set.add(c);
        for(char c:set){
            if(Character.isLowerCase(c)&&!set.contains(Character.toUpperCase(c)))
                return false;
            if(Character.isUpperCase(c)&&!set.contains(Character.toLowerCase(c)))
                return false;
        }
        return true;
    }
}