class Solution {
    public int numSteps(String s) {
        int op=0;
        StringBuilder st=new StringBuilder(s);
        while(st.length()>1){
            int i=st.length()-1;
            if(st.charAt(i)=='0')   divideby2(st);
            else   add1(st);
            op++;
        }
        return op;
    }
    public void divideby2(StringBuilder sb){
        sb.deleteCharAt(sb.length()-1);
    }
    public void add1(StringBuilder sb){
        int i=sb.length()-1;
        while(i>=0 && sb.charAt(i)!='0'){
            sb.setCharAt(i, '0');
            i--;
        }
        if(i<0)    sb.insert(0,'1');
        else    sb.setCharAt(i,'1');
    }
}