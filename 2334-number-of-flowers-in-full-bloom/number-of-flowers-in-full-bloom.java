class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        // int[] ans=new int[people.length];
        int[] ar=Arrays.copyOf(people, people.length);
        Arrays.sort(ar);
        Arrays.sort(flowers, (a,b)->a[0]-b[0]);
        Map<Integer, Integer> map=new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        int idx=0;
        for(int bloom:ar){
            while(idx<flowers.length && flowers[idx][0]<=bloom){
                pq.offer(flowers[idx][1]);
                idx++;
                // System.out.println(pq.peek());
            }
            while(!pq.isEmpty()&&pq.peek()<bloom){
                pq.poll();
            }
            map.put(bloom, pq.size());
        }
        for(int i=0;i<ar.length;i++){
            ar[i]=map.get(people[i]);
        }
        return ar;

    }
}