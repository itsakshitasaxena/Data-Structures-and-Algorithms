class Solution {
    public int numOfWays(int n) {
        long mod=1000000007;
        long x=6,y=6;
        for(int i=2;i<=n;i++){
            long newwx=(3*x+2*y)%mod;
            long newwy=(2*x+2*y)%mod;
            x=newwx;
            y=newwy;
        }
        return (int)((x+y)%mod);
    }
}
/*  For any row, there are only 2 pattern types based on color distribution
Pattern Type 1 (Alternating): Colors alternate - like RYR, YRY, GRG, RGR, YGY, GYG → 6 patterns
Pattern Type 2 (All Different): All different colors - like RGB, RGY, YRG, YGR, GRY, GYR → 6 patterns
Alternating patterns (6 total): first and last columns same, middle different (denoted as x)
All different patterns (6 total): all three columns different (denoted as y)
Both types have 6 variations each, total = 12 w
*/ 