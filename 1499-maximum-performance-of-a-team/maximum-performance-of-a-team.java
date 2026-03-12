class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
         int[][] ar=new int[n][2];
        for(int i=0;i<n;i++){
            ar[i][0]=speed[i];
            ar[i][1]=efficiency[i];
        }
        Arrays.sort(ar,(a,b)->b[1]-a[1]); // sort by efficiency
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        long ans=0, sum=0;
        for(int i=0;i<n;i++){
            pq.add(ar[i][0]);
            sum+=ar[i][0];
            //if size exceeds, deduct sum
            while(pq.size()>k)    sum-=pq.poll();
            ans=Math.max(ans, ar[i][1]*sum);
        }
        return (int)(ans%1000000007);
    }
}