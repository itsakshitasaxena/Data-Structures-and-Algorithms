class Solution {
    public String smallestString(String s) {
         char[] c=s.toCharArray();
        int i=0;
        while(i<s.length()&&c[i]=='a') i++;
        if(i==s.length()){
            c[c.length-1]='z';
            return new String(c);
        }
        while(i<s.length()&&c[i]!='a'){
            c[i]=(char)(c[i]-1);
            i++;
        }
        return new String(c);
    }
}