class Solution {
    public String[] divideString(String s, int k, char fill) {
        int len=s.length()%k==0?s.length()/k:s.length()/k+1;
        String[] div=new String[len];
        int i=0;
        while(i+k<len*k){
            div[i/k]=s.substring(i,i+k);
            i+=k;
        }
        if(i<s.length() && i/k<len){
            int x=0;
            String st=new String();
            while(s.substring(i).length()+x<k){
                st+=fill; x++;
            }
            div[i/k]=s.substring(i)+st;
        }
    
        return div;
    }
}