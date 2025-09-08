class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] ar=new int[2];
        for(int i=1;i<n;i++){
            int a=i, b=n-i;
            if(nonzero(a)&& nonzero(b)){
                ar[0]=a;
                ar[1]=b;
                break;
            }
        }
        return ar;
    }
    public static boolean nonzero(int a){
        while(a>0){
            int dig=a%10;
            if(dig==0)   return false;
            a/=10;
        }
        return true;
    }
}