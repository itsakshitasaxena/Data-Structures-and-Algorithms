class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int xor1=0, xor2=0;
        for(int i:arr1)  xor1^=i;
        for(int j:arr2)  xor2^=j;
        return xor1&xor2;
    }
}