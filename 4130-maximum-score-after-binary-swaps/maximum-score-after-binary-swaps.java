class Solution {
    public long maximumScore(int[] nums, String s) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        long score=0,len=nums.length;
        for(int i=0;i<len;i++){
            pq.add(nums[i]);
            if(s.charAt(i)=='1')
                score+=pq.poll();
        }
        return score;
    }
}