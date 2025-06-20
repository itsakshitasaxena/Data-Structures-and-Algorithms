class Solution {
    public int maxDistance(String s, int k) {
        HashMap<Character, Integer> map=new HashMap<>();
        map.put('N', 0);
        map.put('S', 0);
        map.put('W', 0);
        map.put('E', 0);
        int ans=0, cnt=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.get(ch)+1);
            cnt=Math.min(map.get('E'), map.get('W'))+Math.min(map.get('N'), map.get('S'));
            ans=Math.max(ans, i+1-2*cnt+2*Math.min(cnt,k));
        }
        return ans;
    }
}