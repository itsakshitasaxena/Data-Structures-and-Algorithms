class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0,j=0,a=0;
        int[] ans=new int[nums1.length+nums2.length];
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                ans[a++]=nums1[i++];
            }
            else if(nums1[i]>nums2[j])
                ans[a++]=nums2[j++];
            else{
                ans[a++]=nums1[i++];
                ans[a++]=nums2[j++];
            }

        }
        while(i<nums1.length){
            ans[a++]=nums1[i++];
        }
        while(j<nums2.length){
            ans[a++]=nums2[j++];
        }
        for(int ii=0;ii<ans.length;ii++)
            System.out.print(ans[ii]+" ");
        int n=ans.length;
        double even=(double)(ans[n/2]+ans[(n-1)/2])/2;
        return n%2==0?even:(double)(ans[n/2]);
    }
}