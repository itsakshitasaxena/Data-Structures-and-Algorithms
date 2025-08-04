class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int maxlen=0,start=0,end=0;
        while(end<fruits.length){
            map.put(fruits[end], map.getOrDefault(fruits[end],0)+1);
            while(map.size()>=3){
// The map stores at most 3 keys at any point (though 2 is the limit, temporarily it might hold 3 during adjustment).
                map.put(fruits[start], map.get(fruits[start])-1);
                if(map.get(fruits[start])==0)
                    map.remove(fruits[start]);
// Each fruit is added and removed from the map at most once.
                start++;
            }
            
            maxlen=Math.max(maxlen, end-start+1);
            end++;
        }
        return maxlen;
    }
}