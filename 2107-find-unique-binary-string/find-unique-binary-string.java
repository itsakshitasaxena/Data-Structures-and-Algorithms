class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> hSet=new HashSet<>();
        for(String s:nums)  hSet.add (s);
        for(int j=0;j<nums.length;j++){
            String s=nums[j];
            for(int i=0;i<s.length ();i++){
                char ch= s.charAt(i);
                String n;
                if(ch == '0')
                   n = s.substring(0,i) + '1' + s.substring (i+1);
                else 
                   n = s.substring(0,i) + '0' + s.substring(i+1);
                if(!hSet.contains (n)) 
                   return n;
            }
        }
        return "";
    }
}