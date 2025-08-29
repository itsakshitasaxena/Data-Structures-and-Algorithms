class Solution {
    public long flowerGame(int n, int m) {
        long evenN=n/2, oddN=(n+1)/2;
        
        long evenM=m/2, oddM=(m+1)/2;

        return evenN*oddM+evenM*oddN;

    }
}