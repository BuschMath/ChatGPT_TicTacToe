public class AIPlayer {

    public void play(TicTacToe game) {
        int[] move = minimax(game, game.getCurrentPlayer());
        game.play(move[0], move[1]);
    }

    private int[] minimax(TicTacToe game, char player) {
        char winner = game.checkForWinner();
        if (winner == 'X') {
            return new int[] {-1, -1, 1};
        } else if (winner == 'O') {
            return new int[] {-1, -1, -1};
        } else if (winner == 'T') {
            return new int[] {-1, -1, 0};
        }

        List<int[]> moves = new List<int[]>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (game.getBoard()[i][j] == ' ') {
                    int[] move = new int[] {i, j};
                    game.play(i, j);
                    char opponent = (player == 'X') ? 'O' : 'X';
                    int[] result = minimax(game, opponent);
                    moves.add(new int[] {i, j, result[2]});
                    game.undo();
                }
            }
        }

        int[] bestMove = moves.get(0);
        if (player == 'O') {
            int bestScore = Integer.MIN_VALUE;
            for (int[] move : moves) {
                if (move[2] > bestScore) {
                    bestMove = move;
                    bestScore = move[2];
                }
            }
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int[] move : moves) {
                if (move[2] < bestScore) {
                    bestMove = move;
                    bestScore = move[2];
                }
            }
        }
        return bestMove;
    }
}
