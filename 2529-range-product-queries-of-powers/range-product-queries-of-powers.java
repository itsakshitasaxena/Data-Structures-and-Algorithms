class Solution {
    
    public int[] productQueries(int n, int[][] queries) {
        int mod=1000000007;
        List<Integer> bin=new ArrayList<>();
        int power=1;

        //Breaking n into powers of 2
        while(n>0){
            if(n%2==1)    bin.add(power);
            n/=2;
            power*=2;
        } 

        int[] res=new int[queries.length];
        for(int i=0;i<queries.length;i++){

            int start=queries[i][0];
            int end=queries[i][1];
            long curr=1;
            for(int j=start; j<=end;j++){
                //Each query - multiply bins[start] through bins[end] and % it
                curr=(curr*bin.get(j))%mod;
            }
            res[i]=(int) curr; //adding in answer
        }
        return res;
    }
}