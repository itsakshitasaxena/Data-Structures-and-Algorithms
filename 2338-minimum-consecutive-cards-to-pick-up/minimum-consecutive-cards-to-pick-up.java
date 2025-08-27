class Solution {
    public int minimumCardPickup(int[] cards) {
        int min=Integer.MAX_VALUE;
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<cards.length;i++){
            if(map.containsKey(cards[i])){
                min=Math.min(i-map.get(cards[i])+1,min); 
                //i-map.get(cards[i])+1--a subarray from j to i that includes two same cards
                //size of this subarray is (i - j + 1)
            }
            map.put(cards[i],i);
        }
        return min==Integer.MAX_VALUE?-1:min;

    }
}