class Solution {
    public int edgeScore(int[] edges) {
        long[] scores=new long[edges.length];
        for(int i=0;i<edges.length;i++)
            scores[edges[i]]+=i;
        long max=-1; int idx=-1;
        for(int i=0;i<edges.length;i++){
            if(scores[i]>max){
                max=scores[i];
                idx=i;
            }
        }
        return idx;
    }
}