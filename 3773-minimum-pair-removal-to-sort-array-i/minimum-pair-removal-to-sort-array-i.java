class Solution {
    public int minimumPairRemoval(int[] nums) {
        int cnt=0;
        List<Integer> lst=new ArrayList<>();
        for(int i:nums)
            lst.add(i);
        while(!isSorted(lst)){
            int minsum=Integer.MAX_VALUE;
            int ind=-1;
            for(int i=0;i<lst.size()-1;i++)
                {
                    int sum=lst.get(i)+lst.get(i+1);
                    if(sum<minsum)
                    {
                        minsum=sum;
                        ind=i;
                    }
                }
            int add=lst.get(ind)+lst.get(ind+1);
            lst.set(ind,add);
            lst.remove(ind+1);
            cnt++;
        }
        return cnt;
    }
    public static boolean isSorted(List<Integer> lst){
        for(int i=1;i<lst.size();i++){
            if(lst.get(i)<lst.get(i-1))
                return false;
        }
        return true;
    }
}