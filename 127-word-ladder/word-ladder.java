class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>(wordList);
        // for(String s:wordList)  set.add(s);
        if(!set.contains(endWord))  return 0;
        Queue<Pair> qu=new LinkedList<>();
        qu.add(new Pair(beginWord,1));
        while(!qu.isEmpty()){
            Pair rp=qu.poll();
            String word=rp.ladder;
            int step=rp.steps;
            if(word.equals(endWord)) return step;
            char[] ch=word.toCharArray();
            for(int i=0;i<ch.length;i++){
                char orig=ch[i];
                for(char c='a';c<='z';c++){
                    if(c==orig) continue;
                    ch[i]=c;
                    String newword=new String(ch);
                    if(set.contains(newword)){
                        set.remove(newword);
                        qu.add(new Pair(newword,step+1));
                    }
                }
                ch[i]=orig;
            }
        }
        return 0;

    }
    class Pair{
        String ladder;
        int steps;
        public Pair(String ladder, int steps){
            this.ladder=ladder;
            this.steps=steps;
        }
    }
}