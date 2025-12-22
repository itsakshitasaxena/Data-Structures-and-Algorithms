class Solution {
    public String arrangeWords(String text) {
        String[] st=text.toLowerCase().split(" ");
        Arrays.sort(st,(a,b)->a.length()-b.length());
        st[0]=st[0].substring(0,1).toUpperCase()+st[0].substring(1);
        return String.join(" ",st);
    }
}