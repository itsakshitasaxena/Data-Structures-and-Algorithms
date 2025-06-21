class Solution {
    public int minimumDeletions(String word, int k) {
        HashMap<Character, Integer> map=new HashMap<>();
        for(char ch:word.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        int ans=word.length();
        for(int x:map.values()){
            int del=0;
            for(int y:map.values()){
                if(x>y)
                    del+=y;
                else if(x+k<=y)
                    del+=y-(x+k);

            }
            ans=Math.min(ans,del);
        }
        return ans;
    }
}