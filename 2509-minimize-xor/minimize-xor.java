class Solution {
    public int minimizeXor(int num1, int num2) {
        return find_x(num1, num2);
    }
    public int find_x(int num1, int num2){
        int set_bit=0;
        while(num2>0){
            num2=(num2&(num2-1));
            set_bit++;
        }
        int x=0;
        for(int i=30;i>=0;i--){
            int mask=(1<<i); // 100000
            if((num1&mask)!=0){
                x|=mask; //x=x|mask;
                set_bit--;
                if(set_bit==0) return x;
            }
        }
        for(int i=0;i<=30;i++){ //if set bit remains
             int mask=(1<<i);
            if((num1&mask)==0){
                x|=mask; //x=x|mask;
                set_bit--;
                if(set_bit==0) return x;
            }
        }
        return x;
    }
}