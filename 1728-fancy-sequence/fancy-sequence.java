class Fancy {
List<Long> lst; // → stores "raw" values for each appended element
    long a,b;  // → global multiplier and addend (must be long!)
    int mod=(int)1e9+7;
    public Fancy() {
        lst=new ArrayList<>();
        a=1;
        b=0;
    }
    public long mod_pow(long x, long y, long mod){
        long res=1;
        x%=mod;
        while(y>0){
            if((y&1)==1) // if the least significant bit is 1
                res=(res*x)%mod;  // multiply result by current x
            
            x=(x*x)%mod;  // square x for the next bit
            y>>=1; // shift y right (divide by 2)
        }
        return res;
    }
    
    public void append(int val) {
        long inverse_mul = mod_pow(a, mod - 2, mod);   // → compute a⁻¹ mod MOD
        long saved = ((val - b + mod) % mod * inverse_mul) % mod; // → solve saved = (val - b)/a
        lst.add(saved);
    }
    
    public void addAll(int inc) {
        b = (b + inc) % mod;   // → just increase the global addend
    }
    
    public void multAll(int m) {
        a = (a * m) % mod;   // → multiply the global multiplier
        b = (b * m) % mod;   // → the previous addend also gets multiplied
    }
    
    public int getIndex(int idx) {
       if (idx >= lst.size()) return -1;    // → index out of bounds
        return (int)((a * lst.get(idx) + b) % mod);  // → apply current transformation
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */