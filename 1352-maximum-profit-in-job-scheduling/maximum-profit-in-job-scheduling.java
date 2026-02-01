class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] ar=new int[profit.length][3];
        for(int i=0;i<profit.length;i++){
            ar[i][0]=startTime[i];
            ar[i][1]=endTime[i];
            ar[i][2]=profit[i];
        }
        
        Arrays.sort(ar,(a,b)->a[1]-b[1]); //end time sorting
        TreeMap<Integer, Integer> map=new TreeMap<>(); 
        map.put(0,0); //initially, added endtime and profit as 0->0
        for(int[] i:ar){
            int curr=map.floorEntry(i[0]).getValue()+i[2];
            if(curr>map.lastEntry().getValue())
                map.put(i[1],curr);
        }

        return map.lastEntry().getValue();
    }
}