class Solution {
    public long maxTotal(int[] value, int[] limit) {
        int n=limit.length;
        int[][] valmt=new int[n][2];
        for(int i=0;i<n;i++){
            valmt[i][0]=value[i];
            valmt[i][1]=limit[i];
        }
        Arrays.sort(valmt, (a,b)->{
            if(a[1]!=b[1])  return a[1]-b[1];
            else return  b[0]-a[0];
        });
        int active=1,i=1;
        long sum=valmt[0][0];
        while(i<n){
            active=1;
            while(i<n && valmt[i][1]>active){
                sum+=valmt[i][0];
                if(valmt[i][1]!=valmt[i-1][1])  active=0;
                active++;
                i++;
            }
            while(i<n && valmt[i][1]<=active)  i++;
        }
        return sum;
    }
}