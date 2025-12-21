class Solution {
    public String largestTimeFromDigits(int[] arr) {
        int max=-1;
        for(int i=0 ; i<4 ; i++){
            for(int j=0 ; j<4 ; j++){
                if(i==j) continue;
                int x = arr[i]*10+arr[j];
                if(x>23) continue;

                for(int k=0 ; k<4 ; k++){
                    if(k==i || k==j) continue;

                    int l = 6-i-j-k;
                    int mm = arr[k]*10+arr[l];
                    if(mm>59) continue;

                    max = Math.max(max,x*60+mm);
                }
            }
        }
        if (max == -1) return "";
        return String.format("%02d:%02d", max / 60, max % 60);
    }
}