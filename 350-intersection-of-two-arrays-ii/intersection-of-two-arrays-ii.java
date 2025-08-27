class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> lst=new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                lst.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i]<nums2[j]){
                i++;
            }
            else{
                j++;
            }
        }
        int[] res = new int[lst.size()];
        for (int k = 0; k < lst.size(); k++) {
            res[k] = lst.get(k);
        }
        return res;
    }
}