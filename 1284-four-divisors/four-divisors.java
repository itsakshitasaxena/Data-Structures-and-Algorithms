class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans+=find(nums[i]);
        }
        return ans;
    }
    public int find(int num){
        int sum=0;
        List<Integer> lst=new ArrayList<>();
        for(int i=1;i<=num;i++){
            if(num%i==0){
                lst.add(i);
                if(lst.size()>4) break;
            }
        }
        if(lst.size()==4){
            for(int i=0;i<4;i++) sum+=lst.get(i);
        }
        return sum;
    }
}