class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> qu=new LinkedList<>();
        for(int i=1;i<=n;i++)  qu.offer(i);
        while(qu.size()>1){
            for(int i=1;i<k;i++) //passing the sword k-1 times
                qu.add(qu.poll()); // remove front person & add it back
            
            qu.remove(); //eliminate the kth one 
        }
        return qu.peek();
    }
}