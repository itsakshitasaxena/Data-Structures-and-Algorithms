class Solution {
    public boolean canReach(int[] arr, int start) {
       return isitpossible(arr, start);
    }
    public boolean isitpossible(int[] arr, int idx){
        if(idx<0 || idx>=arr.length)  return false;
        if(arr[idx]==-1)  return false;
        if(arr[idx]==0)  return true;
        int temp=arr[idx];
        arr[idx]=-1;
        boolean left=isitpossible(arr, idx-temp);
        boolean right=isitpossible(arr, idx+temp);
        arr[idx]=temp;
        return left || right;
    }
}