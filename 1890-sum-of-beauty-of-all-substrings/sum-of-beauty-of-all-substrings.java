class Solution {
    public int beautySum(String s) {
    //     int beauty_sum=0;
    //     for(int i=0;i<s.length();i++){
    //         int[] fr=new int[26];
    //         for(int j=i;j<s.length();j++){
    //             fr[s.charAt(j)-'a']++;
    //             beauty_sum+=(getmaxfreq(fr)-getminfreq(fr));
    //         }
    //         // beauty_sum+=(getmaxfreq(fr)-getminfreq(fr));
    //     }
    //     return beauty_sum;
    // }
    // public static int getminfreq(int[] freq){
    //     int min=Integer.MAX_VALUE;
    //     for(int i=0;i<26;i++){
    //         if(freq[i]!=0)
    //             min=Math.min(min,freq[i]);
    //     }
    //     return min;
    // }

    // public static int getmaxfreq(int[] freq){
    //     int max=0;
    //     for(int i=0;i<26;i++)
    //         max=Math.max(max,freq[i]);
    //     return max;
    // }
    int ans=0;
        for(int i=0 ; i<s.length() ; i++){
            int[] arr = new int[26];
            for(int j=i ; j<s.length() ; j++){
                arr[s.charAt(j)-'a']++;
                int max=Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for(int fre : arr){
                    max = Math.max(max,fre);
                    if(fre!=0) min = Math.min(min,fre);
                }
                ans += max-min;
            }
        }
        return ans;
    }
}