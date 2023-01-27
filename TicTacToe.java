import java.util.Arrays;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
  
    public TicTacToe() {
        board = new char[3][3];
        for (char[] row : board) {
            Arrays.fill(row, ' ');
        }
        currentPlayer = 'X';
    }
  
    public void play(int x, int y) {
        if (board[x][y] != ' ') {
            throw new IllegalArgumentException("Cell is already occupied!");
        }
        board[x][y] = currentPlayer;
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
  
    public char checkForWinner() {
        // check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != ' ') {
                return board[i][0];
            }
        }
        // check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] != ' ') {
                return board[0][i];
            }
        }
        // check diagonals
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != ' ') {
            return board[0][0];
        }
        if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != ' ') {
            return board[0][2];
        }
        // check for tie
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') {
                    return ' ';
                }
            }
        }
        return 'T';
    }
  
    public char[][] getBoard() {
        return board;
    }

    public char getCurrentPlayer(){
        return currentPlayer;
    }
}
