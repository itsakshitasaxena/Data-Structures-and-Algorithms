class StockSpanner {
    Stack<Integer> st; //store indices
    ArrayList<Integer> lst; //store prices
    int ind;
    public StockSpanner() {
        st=new Stack<>();
        lst=new ArrayList<>();
        ind=0;
    }
    //have to return max consecutive days for which stock span price <=current day 

    public int next(int price) {
        lst.add(price);

        while(!st.isEmpty() && lst.get(st.peek())<=price)
            st.pop(); //decreasing monotonic stack
        
        int ans=ind- (st.isEmpty()?-1:st.peek());
        st.push(ind++);
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */