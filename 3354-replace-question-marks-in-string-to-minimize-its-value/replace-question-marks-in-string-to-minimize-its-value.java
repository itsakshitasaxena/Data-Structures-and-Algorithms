class Solution {
    public String minimizeStringValue(String s) {
        StringBuilder sb=new StringBuilder();
        int[] fr=new int[26];
        for(char ch:s.toCharArray())
            if(ch!='?') fr[ch-'a']++;
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        for(int i=0;i<26;i++)
            pq.add(new int[]{fr[i],i});
        
        List<Character> lst=new ArrayList<>();
        for(char c:s.toCharArray()){
            if(c=='?'){ 
                int[] cur=pq.poll();
                lst.add((char)(cur[1]+'a'));
                cur[0]++;
                pq.add(cur);
            }
        }
        Collections.sort(lst);
        int idx=0;
        for(char c:s.toCharArray()){
            if(c=='?')   sb.append(lst.get(idx++));
            else sb.append(c);
        }
        return sb.toString();
    }
}