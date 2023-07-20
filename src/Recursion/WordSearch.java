package Recursion;

public class WordSearch {
    static boolean exist(char[][] board, String word){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)){
                    if(wordexist(board,word,i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    static boolean wordexist(char[][]board, String word,int i,int j, int index){
        if(index==word.length()){
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)){
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '#'; // Mark the cell as visited

        boolean found = (wordexist(board,word,i-1,j,index+1) ||
                wordexist(board,word,i+1,j,index+1) ||
                wordexist(board,word,i,j+1,index+1) ||
                wordexist(board,word,i,j-1,index+1) );

        board[i][j] = temp; // Mark the cell as visited
        return found;
    }
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";
        System.out.println(exist(board,word2));
    }
}
