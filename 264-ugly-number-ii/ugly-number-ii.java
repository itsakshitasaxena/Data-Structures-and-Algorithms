class Solution {
    public int nthUglyNumber(int n) {
        long[] ar=new long[n+1];
        ar[0]=1; //first ugly number
        int i3=0, i5=0, i2=0; //initialised 3 pointer to track
        for(int i=1;i<n;i++){
            long val=Math.min(ar[i2]*2, Math.min(ar[i3]*3, ar[i5]*5)); //to get next num
            ar[i]=val; //storing that num
            if(val==ar[i2]*2)  i2++; //tracks next ugly num i.e. /2
            if(val==ar[i3]*3)  i3++; //tracks next ugly num i.e. /3
            if(val==ar[i5]*5)  i5++; //tracks next ugly num i.e. /5
        }
        return (int)ar[n-1];

    }
}