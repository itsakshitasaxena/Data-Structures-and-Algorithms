class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length%2!=0) return new int[0];
        Arrays.sort(changed);
        List<Integer> lst=new ArrayList<>();
        Queue<Integer> qu=new LinkedList<>();
        for(int i=0;i<changed.length;i+=1){
            if(qu.size()>0 && qu.peek()==changed[i])   qu.remove();
            else{
                lst.add(changed[i]);
                qu.add(changed[i]*2);
            }
        }
        if(qu.size()>0)  return new int[]{};
        int[] orig=new int[lst.size()]; int p=0;
        for(int ii:lst)  orig[p++]=ii;
        return orig;
    }
}