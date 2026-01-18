class Solution {
    public int minimumOperations(int[] nums) {
        int[] oddfr=new int[100001];
        int[] evenfr=new int[100001];
        for(int i=0;i<nums.length;i++){
            if(i%2==0)  evenfr[nums[i]]++;
            else oddfr[nums[i]]++;
        }
        int evenmax=0, oddmax=0, evenind=0, oddind=0, n=nums.length;
        for(int i=0;i<100001;i++){ //for first max
            if(evenmax<evenfr[i]){
                evenmax=evenfr[i];
                evenind=i;
            }
            if(oddmax<oddfr[i]){
                oddmax=oddfr[i];
                oddind=i;
            }
        }
        int even_secmax=0, odd_secmax=0, even_secind=0, odd_secind=0;
        for(int i=0;i<100001;i++){ //for second max
            if(even_secmax<evenfr[i] && i!=evenind){
                even_secmax=evenfr[i];
                even_secind=i;
            }
            if(odd_secmax<oddfr[i] && i!=oddind){
                odd_secmax=oddfr[i];
                odd_secind=i;
            }
        }
        if(oddind!=evenind)
            return n-oddmax-evenmax;
        return Math.min(n-odd_secmax-evenmax, n-oddmax-even_secmax);
    }
}