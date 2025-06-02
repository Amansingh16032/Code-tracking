class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        int numIslands = 0;

        //Traverse the grid
        for(int r = 0; r < row; r++) {
            for(int c = 0; c < col; c++) {

                //When we find land
                if(grid[r][c] == '1') {
                    numIslands++;  //New island found
                    dfs(grid,r,c); //Sink the island
                }
            }
        }
        return numIslands;
    }

    //DFS to mark all connected land
    private void dfs(char[][] grid, int r, int c) {
        //Base case: Out of bound or water
        if(r < 0 || c < 0 || r >=  grid.length || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }
        //Mark as visited
        grid[r][c] = '0';

        //Visit 4 direction
        dfs(grid, r-1, c); //Top
        dfs(grid, r+1, c); //Bottom
        dfs(grid, r, c-1); //Left
        dfs(grid, r, c+1); //Right
    }
}