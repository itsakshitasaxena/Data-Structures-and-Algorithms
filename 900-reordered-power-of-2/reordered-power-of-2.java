class Solution {
    public boolean reorderedPowerOf2(int n) {
        String target= sorted(n);


//Java’s int is 32-bit signed → range is -2³¹ to 2³¹ - 1.
//The largest positive power of 2 that fits is 2^30 = 1,073,741,824.
//2^31 would be 2,147,483,648, which is out of range for int (it overflows into a negative value).

        for(int i=0;i<32;i++){
    //1<<i ==> 1*2^i so, instead of using Math.pow(2,i) that takes more time and gives ans in double, i used 1<<i bcoz it directly creates power of 2(0,2,4,8,16,32) by shifting leftmost bit by 1 everytime swiftly
            if(sorted(1<<i).equals(target))
                return true;
            
        }
        return false;
    }
    public String sorted(int num){
        char[] ar=String.valueOf(num).toCharArray();
        Arrays.sort(ar);
        return new String(ar);
    }
}