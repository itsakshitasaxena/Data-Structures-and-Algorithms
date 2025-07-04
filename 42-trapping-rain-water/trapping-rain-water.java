class Solution {
    public int trap(int[] height) {
        // S(C)=O(1), T(C)=O(N) 
        int lmax=0, rmax=0, l=0, r=height.length-1, total=0;;
        while(l<r){
            if(height[l]<=height[r]){
                if(lmax>height[l])  
                    total+=(lmax-height[l]);
                else 
                    lmax=height[l];
                l+=1;
            }
            else{
                if(rmax>height[r])  
                    total+=(rmax-height[r]);
                else 
                    rmax=height[r];
                r-=1;
                }
            }
        return total;
    }
}