class Solution {
    public boolean isValid(String word) {
        if(word.length()<3)  return false;
        boolean vowel=false, conso=false;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(Character.isLetter(ch)){
                ch=Character.toUpperCase(ch);
                if(ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')
                    vowel=true;
                else
                    conso=true;
            }
            else if(!Character.isDigit(ch))
                return false;
           
        }
        return vowel && conso;
    }
}