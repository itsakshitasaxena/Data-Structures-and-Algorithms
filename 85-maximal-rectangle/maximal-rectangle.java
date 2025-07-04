class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0)   return 0;
        int[] prefix=new int[matrix[0].length];
        int maxarea=0;
        for(int i=0;i<matrix.length;i++){
            int sum=0;
            for(int j=0;j<matrix[0].length;j++){
                // sum+=matrix[i][j];
                if(matrix[i][j]=='0')
                    prefix[j]=0;
                else
                    prefix[j]+=1;
            }
            maxarea=Math.max(maxarea, largestRectangleArea(prefix));
        }
        return maxarea;
    }
    public int largestRectangleArea(int[] heights) {
// brute force is to find nse and pse array for each ele of heights and applying the same formula i.e. max(maxarea, ar[i]*(nse[i]-pse[i]-1)) but in this, TC-O(5N) SC-O(4N) so, to optimize this we will find nse and pse in the same loop
        // formula to solve this maxarea=
        // max(maxarea, ar[i]*(nse ka index -pse ka index -1))
        // TC-O(2N), SC-O(N) optimised sol.n
        Stack<Integer> st=new Stack<>();
        int max_area=0;
        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                int ele=st.peek();
                st.pop();
                int nse=i , pse=st.isEmpty()?-1:st.peek();
                max_area=Math.max(max_area, heights[ele]*(nse-pse-1));
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int ele=st.peek();   
            st.pop();
            int nse=heights.length, pse=st.isEmpty()?-1:st.peek();
            max_area=Math.max(max_area, heights[ele]*(nse-pse-1));
        }
        return max_area;
    }
}