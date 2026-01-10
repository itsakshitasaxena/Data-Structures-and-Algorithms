class Solution {
    public int[] avoidFlood(int[] rains) {
        int[] ans=new int[rains.length];
        Arrays.fill(ans,1);
        TreeSet<Integer> set=new TreeSet<>(); //stores indices of dry days
        Map<Integer, Integer> map=new HashMap<>(); //lake--> last filled day
        for(int i=0;i<rains.length;i++){
            if(rains[i]==0){ //these are dry days
                set.add(i);
            }
            else{ //rainy days
                ans[i]=-1;
                if(map.containsKey(rains[i])){ //if lake already full need to dry otheriwse flood 
                    Integer min_dry=set.ceiling(map.get(rains[i])); //give us the earliest dry day as treemap is sorted so using it's direct fn
                    if(min_dry==null)//no valid dry day->flood-> impossible
                        return new int[0];
                    ans[min_dry]=rains[i];
                    set.remove(min_dry);
                }
                map.put(rains[i],i); //update last filled day
            }
        }
        return ans;

    }
}