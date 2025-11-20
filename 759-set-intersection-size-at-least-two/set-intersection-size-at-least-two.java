class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[1]==b[1]?b[0]-a[0]:a[1]-b[1]);
        int cnt=0;
        List<Integer> lst=new ArrayList<>();
        for(int[] ar:intervals){
            int st=ar[0], end=ar[1],c=0,size=lst.size();

            if(size>=1&&lst.get(size-1)>=st)  c++;
            if(size>=2&&lst.get(size-2)>=st)  c++;

            if(c==0){
                lst.add(end-1);
                lst.add(end);
                cnt+=2;
            }
            else if(c==1){
                lst.add(end);
                cnt+=1;
            }
        }
        return lst.size(); //or cnt
    }
}