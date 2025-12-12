class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        boolean[] offln=new boolean[numberOfUsers];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        int[] cnt=new int[numberOfUsers];
        Collections.sort(events,(a,b)->{
            int a1=Integer.parseInt(a.get(1));
            int b1=Integer.parseInt(b.get(1));
            return (a1!=b1)?Integer.compare(a1,b1):(a.get(0).equals("OFFLINE")?-1:1);
        });
        for(List<String> lst:events){
            int timestamp=Integer.parseInt(lst.get(1));
            while(!pq.isEmpty() && pq.peek()[1]<=timestamp)
                offln[pq.poll()[0]]=false;

            if(lst.get(0).equals("OFFLINE")){
                offln[Integer.parseInt(lst.get(2))]=true;
                pq.add(new int[]{Integer.parseInt(lst.get(2)),timestamp+60});
            }
            else{
                if(lst.get(2).equals("HERE")){
                    for(int i=0;i<numberOfUsers;i++){
                        if(!offln[i])  cnt[i]++;
                    }
                }
                else if(lst.get(2).equals("ALL")){
                    for(int i=0;i<numberOfUsers;i++)  cnt[i]++;
                }
                else{
                    String[] st=lst.get(2).split(" ");
                    for(String str:st)
                        cnt[Integer.parseInt(str.substring(2)+"")]++;
                }
            }
        }
        return cnt;
    }
}