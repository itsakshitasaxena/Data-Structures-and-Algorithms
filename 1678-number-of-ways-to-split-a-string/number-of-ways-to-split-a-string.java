class Solution {
    public int numWays(String s) {
        long mod=1000000007,n=s.length(),one=0;
        char[] ch=s.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='1')  one++;
        }
//3 cases-->
// 1. no ones present in the string 
// 2. no. of ones not divisible by 3
// 3. no. of ones divisible by 3

        if(one==0) //case 1
            return (int)(((n-1)*(n-2))/2%mod);
        
        if(one %3!=0)  return 0; //case 2
        long eq_1=one/3,cut1=0,cut2=0; //2 cuts req to make 3 parts
        one=0;
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='1')  one++;
            if(one==eq_1)  cut1++;
            if(one==2*eq_1)  cut2++;
        }
        return (int) ((cut1*cut2)%mod);
    }
}