class Solution {
    public int getWinner(int[] arr, int k) {
        int win=0, max=0,curr=arr[0];
        for(int i=0;i<arr.length;i++){
            max=Math.max(max, arr[i]);
        }
        for(int i=1;i<arr.length;i++){
            if(curr>arr[i]){
                win++;
            }
            else{
                curr=arr[i];
                win=1;
            }
            if(win==k || curr==max)    return curr;
        }
        return max;
    }
}