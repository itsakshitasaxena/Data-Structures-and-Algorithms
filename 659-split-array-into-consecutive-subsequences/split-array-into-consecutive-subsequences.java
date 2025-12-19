class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<>(); //availability for a job
        HashMap<Integer, Integer> vacancy=new HashMap<>(); //vacany map for persons
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])<=0){   
                continue;
            }
            else if(vacancy.getOrDefault(nums[i],0)>0){
                map.put(nums[i], map.getOrDefault(nums[i],0)-1);
                vacancy.put(nums[i], vacancy.getOrDefault(nums[i],0)-1);
                vacancy.put(nums[i]+1,vacancy.getOrDefault(nums[i]+1,0)+1);//opens vacancy for next +1 person
            }

            else if((map.getOrDefault(nums[i],0)>0)&&(map.getOrDefault(nums[i]+1,0)>0)&&(map.getOrDefault(nums[i]+2,0)>0)){ //all  available decrease their cnt 
                map.put(nums[i], map.getOrDefault(nums[i],0)-1);
                map.put(nums[i]+1, map.getOrDefault(nums[i]+1,0)-1);
                map.put(nums[i]+2, map.getOrDefault(nums[i]+2,0)-1);

                vacancy.put(nums[i]+3,vacancy.getOrDefault(nums[i]+3,0)+1); //take  for next subsequence
            }
            else{
                return false;
            }
        }
        return true;
    }
}