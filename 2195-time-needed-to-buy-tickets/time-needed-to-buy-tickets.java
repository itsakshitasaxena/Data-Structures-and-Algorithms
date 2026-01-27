class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> qu=new LinkedList<>();
        for(int i=0;i<tickets.length;i++)  qu.add(i);
        int time=0;
        while(!qu.isEmpty()){
            time++; //inc counter for each iteration
            int top=qu.poll(); //get front person
            tickets[top]-=1;  //ticket bought
            if(k==top && tickets[top]==0) return time;
            if(tickets[top]!=0)  qu.add(top); //re-add curr ind for next iteration
        }
        return time;
    }
}