class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        int large=-1;
        for(int v: map.keySet()){
            if(map.get(v)==v)
                large=Math.max(large, map.get(v));
        }
        return large;
    }
}