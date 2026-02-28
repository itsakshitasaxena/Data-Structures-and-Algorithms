class Solution {
    public int concatenatedBinary(int n) {
        String st = "";
        int mod = 1000000007;
        for(int i=1; i<=n; i++){
            st+=Integer.toBinaryString(i);
            long val = Long.parseLong(st,2);
            val = val%mod;
            st = Long.toBinaryString(val);
        }
        return (int)Long.parseLong(st,2);
    }
}