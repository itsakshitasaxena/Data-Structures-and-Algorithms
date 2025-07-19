class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> res=new ArrayList<>();
        res.add(folder[0]);
        for(int i=1;i<folder.length;i++){
           String lastfold= res.get(res.size()-1); //getting the last folder added to result list
            if(!folder[i].startsWith(lastfold+"/"))
                res.add(folder[i]);
        }
        return res;
    }
}