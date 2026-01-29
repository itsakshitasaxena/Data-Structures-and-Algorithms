class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> prod=new HashMap<>();
        int res=0;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                int mul=nums[i]*nums[j];
                res+=prod.getOrDefault(mul,0);
                prod.put(mul, prod.getOrDefault(mul,0)+1);

            }
        }
        return res*8;
    }
}