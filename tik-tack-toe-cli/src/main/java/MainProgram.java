import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TTTModel game = new TTTModel();

        while (!game.checkForWin()) {
            char[][] board = game.getBoard();
            System.out.println("-------------");
            System.out.println("| " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " |");
            System.out.println("-------------");
            System.out.println("| " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " |");
            System.out.println("-------------");
            System.out.println("| " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " |");
            System.out.println("-------------");
            System.out.println("Current player: " + game.getCurrentPlayer());
            System.out.print("Enter row: ");
            int row = scanner.nextInt() -1;
            System.out.print("Enter column: ");
            int col = scanner.nextInt() -1;
            if (!game.makeMove(row, col)) {
                System.out.println("Invalid move, try again!");
            }
        }
        System.out.println("Player " + game.getCurrentPlayer() + " wins!");
    }
}
