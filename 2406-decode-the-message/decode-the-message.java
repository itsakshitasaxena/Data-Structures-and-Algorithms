class Solution {
    public String decodeMessage(String key, String message) {
        
        char ch='a';
        HashMap<Character, Character> map=new HashMap<>();
        for(char c:key.toCharArray()){
            if( c!=' '&& !map.containsKey(c)){
                map.put(c,ch);
                ch+=1;
            }
        }

        StringBuilder sb=new StringBuilder();
        for(char c:message.toCharArray()){
            if(c!=' '){
                sb.append(map.get(c));
            }
            else{
                sb.append(' ');
            }
            
        }
        return sb.toString();
    }
}