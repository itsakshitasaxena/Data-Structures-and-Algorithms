class Solution {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        // sliding window : question itself saying☺️
        int i=0,st=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> skipped = new HashSet<>();
        // fixed window size
        int ans=0;
        for( ; i<w && i<arrivals.length ; i++){
            if(map.getOrDefault(arrivals[i],0)>=m){
                ans++;
                skipped.add(i);
                continue;
            }
            map.put(arrivals[i],map.getOrDefault(arrivals[i],0)+1);
        }
        while(i<arrivals.length){
            if(!skipped.contains(st)){
                map.put(arrivals[st],map.get(arrivals[st])-1);
            }
            if(map.getOrDefault(arrivals[i],0)==m){
                ans++;
                skipped.add(i);
            }
            else
                 map.put(arrivals[i],map.getOrDefault(arrivals[i],0)+1);
            i++;
            st++;
        }
        return ans;
    }
}