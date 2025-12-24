class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int sum=0, box=0;
        for(int i:apple)  sum+=i;
        int j=capacity.length-1;
        while(j>=0){
            sum-=capacity[j];
            box++;
            if(sum<=0)  break;
            j--;
        }
        return box;
    }
}