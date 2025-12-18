class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> lst=new ArrayList<>();
        combosum(candidates, 0,target, lst, ans);
        return ans;
    }
    public void combosum(int[] ar, int ind, int target,List<Integer> lst, List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(lst));
            return;
        }
        for(int i=ind;i<ar.length;i++){
            if(ar[i]<=target){
                lst.add(ar[i]);
                combosum(ar, i,target-ar[i], lst, ans);
                lst.remove(lst.size()-1);
            }
        }
    }
}