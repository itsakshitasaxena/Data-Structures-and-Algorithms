class Solution {
    public int maximalRectangle(char[][] ar) {
        int[] h=new int[ar[0].length];
        int largest=0;
        for(int i=0;i<ar.length;i++){
            for(int j=0;j<ar[0].length;j++){
                h[j]=ar[i][j]=='0'?0:h[j]+(ar[i][j]-'0');
            }
            largest=Math.max(largest, largestRectangleArea(h));
        }
        return  largest;
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int max=0;
        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[i]<heights[st.peek()]){ //jis value pr hu vo choti honi chahiye peek se
            int h=heights[st.pop()]; //pop krenge kuki iss height ki ab need ni h future m
            int r=i; //jahan pr abhi hu wahan right pointer rahega
            if(st.isEmpty()){
                max=Math.max(max,h*r);
            }
            else{
                int l=st.peek();
                max=Math.max(max,h*(r-l-1));
            }
            }
            st.push(i);
        }
        int r=heights.length;
        while(!st.isEmpty()){
            int h=heights[st.pop()]; //pop krenge kuki iss height ki ab need ni h future m
            if(st.isEmpty()){
                max=Math.max(max,h*r);
            }
            else{
                int l=st.peek();
                max=Math.max(max,h*(r-l-1));
            }
        }
        return max;
    }
}