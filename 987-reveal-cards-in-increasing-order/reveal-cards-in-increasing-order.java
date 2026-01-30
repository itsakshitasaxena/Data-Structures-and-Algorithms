class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n=deck.length,idx=0;
        int[] ans=new int[n];
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=n-1;i>=0;i--){
            if(!dq.isEmpty())  
                dq.addFirst(dq.pollLast()); //move last card to front id dq!=empty
            dq.addFirst(deck[i]); //ad current card to front
        }
        for(int a:dq) ans[idx++]=a;
        return ans;
    }
}