class Solution {
    public int maxRepeating(String sequence, String word) {
        int k=0;
        StringBuilder sb=new StringBuilder(word);
        while(sequence.contains(sb)){
            sb=sb.append(word);
            k++;
        }
        return  k;
    }
}