class Solution {
    public boolean checkValidString(String s) {
        int lo=0; // lo= minimum possible number of unmatched '('
        int hi=0; //hi = maximum possible number of unmatched '('
        for(char ch:s.toCharArray()){
            if(ch=='('){ //both brackets cnt inc
                lo++;
                hi++;
            }
            else if(ch==')'){
                if(lo>0)  lo--; //reduces open brackets
                hi--;
            }
            else{ // * --> '(' or ')'
                if (lo > 0) lo--; //  ')'  decrease lo
                hi++;            //  '(' -> increase hi
            }
            if(hi<0) return false; // If max open cnt becomes negative,too many ')' encountered → invalid
        }
        return lo==0; //min open brkt must be 0
    }
}