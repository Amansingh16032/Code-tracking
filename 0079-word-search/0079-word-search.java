class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int index) {
        //Full word is matched
        if(index == word.length()) return true;
        //Out of bounds or char mismatch
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        //Save the current letter and mark visited
        char temp = board[i][j];
        board[i][j] = '#';

        //Explore all 4 directions
        boolean found = dfs(board, word, i+1, j, index+1)||
                        dfs(board, word, i-1, j, index+1)||
                        dfs(board, word, i, j+1, index+1)||
                        dfs(board,word, i, j-1, index+1);

                        //Restore original letter(backtrack)
                        board[i][j] = temp;

                        return found;
    }
}