class Solution {
    public int orangesRotting(int[][] grid) {
            int rows = grid.length, cols = grid[0].length;
            Queue<int[]> queue = new LinkedList<>();
            int fresh = 0;

            for(int r = 0; r < rows; r++) {
                for(int c = 0; c < cols; c++) {
                    if(grid[r][c] == 2) {
                        queue.add(new int[]{r,c});
                    } else if(grid[r][c] == 1) {
                        fresh++;
                    }

                }
            }
            if(fresh == 0) return 0;

            int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
            int minutes = 0;
    
            while(!queue.isEmpty()) {
                int size = queue.size();
                boolean rottedThisMinute = false;

                for(int i = 0 ;i < size; i++) {
                    int[] point = queue.poll();
                    int row = point[0], col = point[1];

                    for(int[] dir : directions) {
                        int newRow = row + dir[0], newCol = col + dir[1];

                     if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.add(new int[]{newRow, newCol});
                        fresh--;
                        rottedThisMinute = true;
                     }   
                    }

                }
                if(rottedThisMinute) {
                    minutes++;
                }
            }

               return fresh == 0 ? minutes : -1;             
            
    }       
    
}