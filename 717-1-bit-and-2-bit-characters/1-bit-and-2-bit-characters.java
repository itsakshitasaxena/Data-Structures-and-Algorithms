class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        for(int i=0;i<bits.length;)
        {
            if(bits[i]==1)
            {
                if(i+1>=bits.length-1)
                  return false;
                i+=2;
            }
            else
            {
                i+=1;
            }
        }
        return true;
    }
}