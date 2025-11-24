class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans=new ArrayList<>();
        int pref=0;
        for(int i:nums){
            pref=((pref*2)+i)%5;  //*2= left shift
            if(pref%5==0)  ans.add(true);
            else  ans.add(false);
        }
        return ans;
    }
}