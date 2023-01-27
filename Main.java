import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Current board:");
            printBoard(game.getBoard());
            System.out.println("Player " + game.getCurrentPlayer() + ", enter your move (x y): ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            game.play(x, y);
            char winner = game.checkForWinner();
            if (winner != ' ') {
                if (winner == 'T') {
                    System.out.println("It's a tie!");
                } else {
                    System.out.println("Player " + winner + " wins!");
                }
                break;
            }
        }
        scanner.close();
    }
  
    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            System.out.println(row);
        }
    }
}
