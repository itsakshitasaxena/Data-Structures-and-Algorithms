class FindSumPairs {
    int[] nums1;
    int[] nums2;
    Map<Integer, Integer> cnt=new HashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1=nums1;
        this.nums2=nums2;
        this.cnt=new HashMap<>();
        for(int num:nums2){
            cnt.put(num, cnt.getOrDefault(num,0)+1);
        }
    }
    
    public void add(int index, int val) {
        int oldval=nums2[index];
        cnt.put(oldval, cnt.get(oldval)-1);
        nums2[index]+=val;
        cnt.put(nums2[index], cnt.getOrDefault(nums2[index],0)+1);
    }
    
    public int count(int tot) {
        int res=0;
        for(int num:nums1){
            int rest=tot-num;
            res+=cnt.getOrDefault(rest,0);
        }      
        return res;  
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */