class Solution {
    public int maximumLength(String s) {
          /*
         len[c][0] → largest length of consecutive character c
         len[c][1] → 2nd largest length
         len[c][2] → 3rd largest length

         We only need top 3 because we want the substring
         to appear AT LEAST 3 TIMES
        */

        int[][] len=new int[26][3];// For each char, store its top 3 longest lengths
        int currlen=0, ans=0;
        for(int i=0;i<s.length();i++){
            if(i>0 && s.charAt(i-1)==s.charAt(i)) currlen++;
            else currlen=1;
            int ch=s.charAt(i)-'a';
            update(len[ch], currlen);  // Insert currLen into top 3 of best[c]
        }
        
        for(int i=0;i<26;i++){  // Find maximum 3rd largest among all characters
            ans=Math.max(ans, len[i][2]);
        }
        return ans==0 ? -1 : ans;
    }

    /*This function keeps the top 3 maximum values 
    in descending order: ar[0] ≥ ar[1] ≥ ar[2]*/
    public void update(int[] ar, int val){ // Maintain top 3 values in descending order
        if(val>ar[0]){
            ar[2]=ar[1];
            ar[1]=ar[0];
            ar[0]=val;
        }
        else if(val > ar[1]){
            ar[2]=ar[1];
            ar[1]=val;
        }
        else if(val>ar[2]){
            ar[2]=val;
        }
    }
}

/*
why 3rd largets?
Because each len[i] contributes one occurrence, and we need at least 3 occurrences, so the 3rd largest length is the maximum possible valid length.
*/