class Solution {
    public int maximum69Number (int num) {
        char[] ar=Integer.toString(num).toCharArray();
        for(int i=0;i<ar.length;i++){
            if(ar[i]-'0'!=9){
                ar[i]='9';
                break;
            }
        }
        String st=new String(ar);
        return Integer.parseInt(st);
    }
}