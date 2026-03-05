class Solution {
    public int minOperations(String s) {
        int zero=0, one=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(i%2==0){
                if(ch=='0')   one++;
                else zero++;
            }
            else{
                if(ch=='1')  one++;
                else zero++;
            }
        }
        return Math.min(zero, one);
    }
}