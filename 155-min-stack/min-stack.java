class MinStack {
    Stack<Integer> st1;
    Stack<Integer> st2;
    public MinStack() {
        st1=new Stack<>();
        st2=new Stack<>();
    }
    
    public void push(int val) {
        st2.push(val);
        if(st1.isEmpty() || val<=st1.peek())
            st1.push(val);
    }
    
    public void pop() {
        if(st1.peek().equals(st2.peek()))
            st1.pop();
        st2.pop();
    }
    
    public int top() {
        return st2.peek();
    }
    
    public int getMin() {
        return st1.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */