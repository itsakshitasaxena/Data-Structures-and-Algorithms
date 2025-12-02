class Solution {
    public int findPairs(int[] nums, int k) {
        // Arrays.sort(nums);
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i:nums)
            map.put(i,map.getOrDefault(i,0)+1);
        int cnt=0;
        for(int i:map.keySet()){
            if(k==0){ //if diff=0,search for same number to be in pair
               if(map.get(i)>1) cnt++;
            }
            //see-a-b=k  so a=b+k if we have b then its pair would be b+k i.e.-a
            else {
                if(map.containsKey(i+k)) cnt++; 
            }
        }
        return cnt;
    }
}