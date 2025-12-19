class Solution {
    public String longestWord(String[] words) {
        String result="";
        HashSet<String> word=new HashSet<>();
        Arrays.sort(words);
        for(String i:words)
        {
            if(i.length()==1||word.contains(i.substring(0,i.length()-1)))
            {
                if(i.length()>result.length())    result=i;
                word.add(i);
            }
        }
        return result;
    }
}