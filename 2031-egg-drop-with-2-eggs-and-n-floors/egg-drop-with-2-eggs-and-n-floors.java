class Solution {
    public int twoEggDrop(int n) {
        int coveredFloors=0,moves=0;
        // keep increasing moves until we can cover all floors
        while (coveredFloors < n) {
            moves++;
            coveredFloors += moves;
        }
        return moves;
    }
}