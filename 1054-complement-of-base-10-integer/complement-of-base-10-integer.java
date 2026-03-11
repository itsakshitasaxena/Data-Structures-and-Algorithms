class Solution {
    public int bitwiseComplement(int n) {
        String st=Integer.toBinaryString(n);
        StringBuilder flip=new StringBuilder();
        for(char ch:st.toCharArray()) flip.append(ch=='0'? '1' : '0');
        return Integer.parseInt(flip.toString(),2);
    }
}