class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans=new ArrayList<>();
        int mindiff=Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i++)
            mindiff=Math.min(mindiff,arr[i+1]-arr[i]);
        
        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1]==mindiff){
                List<Integer> lst=new ArrayList<>();
                lst.add(arr[i-1]);
                lst.add(arr[i]);
                ans.add(lst);
            }
        }
        return ans;
    }
}