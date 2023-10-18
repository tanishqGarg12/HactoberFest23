import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        char currentPlayer = 'X';
        boolean gameWon = false;

        while (true) {
            printBoard(board);

            int[] move = getInput(board);
            int row = move[0];
            int col = move[1];

            if (board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                gameWon = checkWin(board, currentPlayer);
                if (gameWon) {
                    printBoard(board);
                    System.out.println(currentPlayer + " wins!");
                    break;
                }

                if (currentPlayer == 'X') {
                    currentPlayer = 'O';
                } else {
                    currentPlayer = 'X';
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }

            if (isBoardFull(board) && !gameWon) {
                printBoard(board);
                System.out.println("It's a draw!");
                break;
            }
        }
    }

    public static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public static int[] getInput(char[][] board) {
        Scanner scanner = new Scanner(System.in);
        int[] move = new int[2];
        while (true) {
            System.out.print("Enter row and column (e.g., 1 2): ");
            move[0] = scanner.nextInt() - 1;
            move[1] = scanner.nextInt() - 1;

            if (move[0] >= 0 && move[0] < 3 && move[1] >= 0 && move[1] < 3) {
                break;
            } else {
                System.out.println("Invalid input. Row and column must be between 1 and 3.");
            }
        }
        return move;
    }

    public static boolean checkWin(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true; // Horizontal win
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true; // Vertical win
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true; // Diagonal win (top-left to bottom-right)
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true; // Diagonal win (top-right to bottom-left)
        }
        return false;
    }

    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
