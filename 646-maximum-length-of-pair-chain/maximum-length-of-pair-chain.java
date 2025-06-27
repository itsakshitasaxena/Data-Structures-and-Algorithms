class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->Integer.compare(a[1],b[1]));
        int c=1, pair=pairs[0][1];
        for(int i=1;i<pairs.length;i++){
            if(pair<pairs[i][0]){
                c++;
                pair=pairs[i][1];
            }
        }
        return c;
    }
}