class Solution {
    public int minDeletionSize(String[] strs) {
        int cnt=0,n=strs.length,m=strs[0].length();
        boolean[] arr=new boolean[n-1]; //arr[j]=strs[j] < strs[j+1] already decided
        for(int i=0;i<m;i++){ //cols
            boolean flag=false;
            for(int j=0;j<strs.length-1;j++){ //rows
                if(!arr[j]&&strs[j].charAt(i)>strs[j+1].charAt(i)){
                    flag=true;break;
                }
            }
            if(flag)  cnt++;
            else{
                for(int j=0;j<strs.length-1;j++){ //rows
                if(!arr[j]&&strs[j].charAt(i)<strs[j+1].charAt(i))
                        arr[j]=true;   
                }   
            }
        }
        return cnt;
    }
}