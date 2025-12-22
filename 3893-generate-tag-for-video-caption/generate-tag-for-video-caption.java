class Solution {
    public String generateTag(String caption) {
        StringBuilder ans=new StringBuilder();
        ans.append("#");
        boolean f=false;
        int i=0;
        while(i<caption.length() && caption.charAt(i)==' ')  i++;
        for(;i<caption.length() && ans.length()<100;i++){
            char ch=caption.charAt(i);
            if(ch==' ')  f=true;
            if(!Character.isLetter(ch)) continue;
            if(f){
                if(Character.isUpperCase(ch)){
                    ans.append(ch);
                }
                else{
                    ans.append((char)(ch-32));
                    // f=false;
                }
                f=false;
            }
            else if(Character.isUpperCase(ch)){
                ans.append((char)(ch+32));
            }
            else{
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}