class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] nse=new int[arr.length];
        int[] psee=new int[arr.length];
// we find the next and previous equal element of arr[i] then we get the min of all subarrays 

        Stack<Integer> st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i])
                st.pop();
            psee[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }

        Stack<Integer> st1=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!st1.isEmpty() && arr[st1.peek()]>=arr[i])
                st1.pop();
            nse[i]=st1.isEmpty()?arr.length:st1.peek();
            st1.push(i);
        }
        
        long min_sum=0, mod=(int)(1e9+7);
        for(int i=0;i<arr.length;i++){
            int left=i-psee[i];
            int right=nse[i]-i;
// this left*right give the number of subarrays *arr[i] gives the min ele is repeating in these subarrays 
            min_sum+=(long)(left*right%mod*arr[i]%mod);
            min_sum%=mod;
        }
        return (int)min_sum;
    }
}