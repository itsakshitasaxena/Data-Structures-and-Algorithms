class Solution {
    public int edgeScore(int[] edges) {
        // HashMap<Integer, Long> map=new HashMap<>();
        // for(int i=0;i<edges.length;i++){
        //     map.put(edges[i],map.getOrDefault(edges[i],0L)+i);
        // }
        int ans=0;long max=Long.MIN_VALUE;
        // for(int i:map.keySet()){
        //     if(map.get(i)>max||max==map.get(i)&&i<ans){
        //         ans=i;max=map.get(i);
        //     }
        // }
        // return (int)ans;
        long[] score=new long[edges.length];
        for(int i=0;i<edges.length;i++){
            score[edges[i]]+=i;
        }
        for(int i=edges.length-1;i>=0;i--){
            if(score[i]>=max){
                max=score[i];
                ans=i;
            }
        }
        return ans;
    }
}