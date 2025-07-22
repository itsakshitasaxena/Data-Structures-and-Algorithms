class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success){
        Arrays.sort(potions);
        int[] ans=new int[spells.length];
        int i=0;
        while(i<spells.length){
            int left=0, right=potions.length-1,strength=potions.length;
            while(left<=right){
                int mid=left+(right-left)/2;
                if(spells[i]*(long)potions[mid]>=success){
                    strength=mid;
                    right=mid-1;
                }
                else   left=mid+1;
            }
            ans[i++]=potions.length-strength;
            
        }
        return ans;
    }
}