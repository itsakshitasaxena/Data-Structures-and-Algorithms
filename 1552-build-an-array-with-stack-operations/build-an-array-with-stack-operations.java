class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans=new ArrayList<>();
        for(int i=1,j=0;i<=n && j<target.length;i++){
            if(i==target[j]){
                ans.add("Push");
                j++;
            }
            else if(i<target[j]){
                ans.add("Push");
                ans.add("Pop");
            }

        }
        return ans;
    }
}