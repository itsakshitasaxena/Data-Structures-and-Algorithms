class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int matchings=0,i=0,j=0;
        while(j<trainers.length && i<players.length){
            if(players[i]<=trainers[j]){
                matchings++;
                i++;
            }
            j++;
        }
        return matchings;
    }
}