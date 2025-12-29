class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n=arr.length,left=0,right=arr.length-1;
        while(left+1<n&&arr[left]<=arr[left+1]) //left increasing part
            left++;
        while(right-1>=0&&arr[right]>=arr[right-1]) //right increasing part
            right--;
        if(left>=right)  return 0;//already sorted
        int ans=Math.min(n-left+1,right); 
        for(int i=0;i<=left;i++){
            int j=binsearch(arr[i],right,n,arr);
            ans=Math.min(ans,j-(i+1));
        }
        return ans;
    }
    public int binsearch(int goal,int left, int right,int[] ar){
        while(left<right){ //finding lowerbound
            int mid=left+(right-left)/2;
            if(ar[mid]>=goal)  right=mid;
            else left=mid+1;
        }
        return left;
    }
}