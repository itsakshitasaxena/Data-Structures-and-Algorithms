class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String key=GetKey(strs[i]);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        List<List<String>> ans=new ArrayList<>();
        for(String key:map.keySet())
            ans.add(map.get(key));
        
        return ans;

    }
    public static String GetKey(String s){
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<freq.length;i++){
            sb.append(freq[i]+" "); //it generates the unique key for all strings
        }
        return sb.toString(); 
    }
}
