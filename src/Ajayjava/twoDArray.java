package Ajayjava;

public class twoDArray {
        public static void main(String[] args) {
            char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
            String word = "ASAD";
            boolean a= exist(board,word);
           System.out.println(exist(board,word));

        }
        static boolean[][] visited;

        static boolean exist(char[][] board, String word) {
            int rows = board.length;
            int cols = board[0].length;
            visited = new boolean[rows][cols];

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (search(board, row, col, word, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        static boolean search(char[][] board, int row, int col, String word, int index) {
            if (index == word.length()) {
                return true; // Word found
            }

            if (row < 0 || col < 0 || row >= board.length || col >= board[0].length ||
                    visited[row][col] || board[row][col] != word.charAt(index)) {
                return false; // Out of bounds or visited or mismatch
            }

            visited[row][col] = true;

            // Check adjacent cells
            boolean found = search(board, row + 1, col, word, index + 1) ||
                    search(board, row - 1, col, word, index + 1) ||
                    search(board, row, col + 1, word, index + 1) ||
                    search(board, row, col - 1, word, index + 1);

            visited[row][col] = false; // Backtrack

            return found;
}


}
