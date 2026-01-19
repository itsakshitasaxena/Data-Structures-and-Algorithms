class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st=new Stack<>();
        for(String a:operations){
            if(a.equals("D")){
                st.push(2*st.peek());
            }
            else if(a.equals("C")){
                st.pop();
            }
            else if(a.equals("+") ){
                int p=st.pop();
                int q=st.peek();
                st.push(p);
                st.push(p+q);
            }
            else{
                st.push(Integer.parseInt(a));
            }
        }
        int sum=0;
        while(!st.isEmpty()){
            sum+=(st.pop());
        }
        return sum;
    }
}