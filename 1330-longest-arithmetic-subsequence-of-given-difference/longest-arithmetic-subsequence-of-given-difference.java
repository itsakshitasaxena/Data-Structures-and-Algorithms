class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int prev=(map.containsKey(arr[i]-difference)
            ?map.get(arr[i]-difference)
            :0);
            map.put(arr[i],prev+1);
            max=Math.max(max, map.get(arr[i]));
        }
        return max;
    }
}