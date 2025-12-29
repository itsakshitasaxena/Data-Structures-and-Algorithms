class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n=arr.length,left=0,right=arr.length-1;
    // By using 2 pointers-optimised-O(N)&O(1)
        while(right>0&&arr[right]>=arr[right-1]){
            right--;
        }
        int ans=right;
        while(left<right&&(left==0||arr[left-1]<=arr[left])){
            //next valid ele after arr[left]
            while(right<arr.length&&arr[left]>arr[right])  right++;
            ans=Math.min(ans,right-left-1);
            left++;
        }
        return ans;
    }
    //By using binary search-O(NlogN)& O(N)
    //     while(left+1<n&&arr[left]<=arr[left+1]) //left increasing part
    //         left++;
    //     while(right-1>=0&&arr[right]>=arr[right-1]) //right increasing part
    //         right--;
    //     if(left>=right)  return 0;//already sorted
    //     int ans=Math.min(n-left+1,right); 
    //     for(int i=0;i<=left;i++){
    //         int j=binsearch(arr[i],right,n,arr);
    //         ans=Math.min(ans,j-(i+1));
    //     }
    //     return ans;
    // }
    // public int binsearch(int goal,int left, int right,int[] ar){
    //     while(left<right){ //finding lowerbound
    //         int mid=left+(right-left)/2;
    //         if(ar[mid]>=goal)  right=mid;
    //         else left=mid+1;
    //     }
    //     return left;
    // }
}