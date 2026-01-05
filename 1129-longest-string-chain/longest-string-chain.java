class Solution {
    HashSet<String> set;
    HashMap<String,Integer> map;
    public int longestStrChain(String[] words) {
        set=new HashSet();
        map=new HashMap<>();
        for(String s:words) set.add(s);
        int[] dp=new int[words.length];
        int max=0;
        for(int i=0;i<words.length;i++){
            max=Math.max(max,chain(words[i]));
        }
        return max;
    }
    public int chain( String words){
        if(map.containsKey(words))  return map.get(words);
        int max=1;
        for(int j=0;j<words.length();j++){
            String s=words.substring(0,j)+words.substring(j+1);
            if(set.contains(s)){
                max=Math.max(chain(s)+1,max);
            }
        }
        map.put(words,max);
        return max;
    }
}