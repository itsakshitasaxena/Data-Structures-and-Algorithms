class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        HashSet<Integer> set=new HashSet<>();
        for(int arr_time:passengers)  set.add(arr_time); 

        int pi=0, pass_cnt=0, lastboard=0;
        for(int dept:buses){
            int cnt=0;
            while(pi<passengers.length && passengers[pi]<=dept && cnt<capacity){
                lastboard=passengers[pi]; //last passenger arrival_time
                cnt++;
                pi++;
            }
            pass_cnt=cnt; //tracks capacity of curr bus
        }

        int latest_time=0;
        if(pass_cnt<capacity)   latest_time=buses[buses.length-1]; 
        else latest_time=lastboard-1; 

        while(set.contains(latest_time))  latest_time-=1;
        return latest_time;
        
    }
}