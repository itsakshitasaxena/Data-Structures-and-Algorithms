class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set=new HashSet<>();
        for(int val:arr1){
            String st=""+val;
            for(int i=0;i<st.length();i++){
                int curr=Integer.parseInt(st.substring(0,i+1));
                set.add(curr);
            }
        }
        int ans=0;
        for(int val:arr2){
            String st=""+val;
            for(int i=ans;i<st.length();i++){
                int curr=Integer.parseInt(st.substring(0,i+1));
                if(set.contains(curr))
                    ans=i+1;
            }
        }
        return ans;
    }
}