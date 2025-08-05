class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int remain=0,i=0;
        boolean[] placed=new boolean[fruits.length];
        while(i<fruits.length){
            int j=0;
            boolean f=false;
            while(j<baskets.length){
                if(!placed[j] && fruits[i]<=baskets[j]) {
                    placed[j]=true;
                    f=true;
                    
                    break;
                }
                
                j++;
            }
            if(!f)    remain++;
            i++;
        }
        return remain;   
    }
}