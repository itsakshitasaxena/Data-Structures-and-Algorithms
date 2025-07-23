class Solution {
    public int maximumGain(String s, int x, int y) {
        int pt=0, c1=0, c2=0;
        char ch1='a', ch2='b';
        if(x<y){
            int temp=x;
            x=y;
            y=temp;
            ch1='b';
            ch2='a';
        }

        for( char ch:s.toCharArray()){
            if(ch==ch1)   c1++;
            else if(ch==ch2){
                if(c1>0){
                    c1--;
                    pt+=x;
                }
                else{
                    c2++;
                }
            }
            else{
                pt+=Math.min(c1,c2)*y;
                c1=0; c2=0;
            }
            // pt+=Math.min(c1,c2)*y;
        }
        pt+=Math.min(c1,c2)*y;
        return pt;
    }
}