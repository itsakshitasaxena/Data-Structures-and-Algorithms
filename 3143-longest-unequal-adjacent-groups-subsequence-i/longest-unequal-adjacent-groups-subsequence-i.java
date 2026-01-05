class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> lst=new ArrayList<>();
        for(int i=0;i<groups.length;i++){
            if(i==0||groups[i]!=groups[i-1])
                lst.add(words[i]);
        }
        return lst;
    }
}