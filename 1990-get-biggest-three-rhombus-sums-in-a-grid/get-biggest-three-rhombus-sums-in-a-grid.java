class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        Set<Integer> sums = new HashSet<>(); // To store DISTINCT rhombus sums
        for(int i=0;i<m;i++){ // Try every cell as rhombus center
            for(int j=0;j<n;j++){
                for(int d=0; d<26; d++){ // d =radius(distance from center-->corner)
                    if(i-d<0 || j-d<0 || i+d>=m || j+d>=n)   break;// if ❌ in range
                    int temp = 0;
                    if(d==0)   // CASE 1: size = 0 (single cell rhombus)
                         temp = grid[i][j];
                     else {  // Add the 4 CORNERS of rhombus
                        temp = grid[i-d][j]   // top
                                + grid[i+d][j]   // bottom
                                + grid[i][j-d]   // left
                                + grid[i][j+d];  // right

                        for(int t=1;t<d;t++){ // Traverse the 4 EDGES b/w corners
                            temp += grid[i+t][j+d-t];  // bottom-right edge
                            temp += grid[i+t][j-d+t];  // bottom-left edge
                            temp += grid[i-t][j+d-t];  // top-right edge
                            temp += grid[i-t][j-d+t];  // top-left edge
                        }
                    }
                    sums.add(temp);  // store distinct sums
                }
            }
        }
        List<Integer> list = new ArrayList<>(sums); //convert in list
        Collections.sort(list, Collections.reverseOrder());   // sort descending
        int k = Math.min(3, list.size()); // we only need top 3
        int[] ans = new int[k];
        for(int i=0;i<k;i++)  ans[i] = list.get(i);
        return ans;
    }
}