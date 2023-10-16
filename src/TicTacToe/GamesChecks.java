package TicTacToe;

public class GamesChecks {

    public boolean isValid(int row, int col, char[][] board) {
        if (row >= 0 && row < board.length && col >= 0 && col < board[0].length) {
            if (board[row][col] == '_' || board[row][col] == ' ') {
                return true;
            }
        }
        return false;

    }

    public boolean rowVictory(char letter, char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == letter && board[i][i] == letter && board[i][2] == letter) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasContestantWon(char[][] board, char symbol) { //if someone won
        if ((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
                (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
                (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
                (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
                (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
            return true;
        }
        return false;

    }


    public boolean colVictory(char letter, char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[0][i] == letter && board[1][i] == letter && board[2][i] == letter) {
                return true;
            }
        }
        return false;
    }

    public boolean diagonalVictory(char letter, char[][] board) {
        if (board[1][1] != letter) {
            return false;
        }
        if (board[0][0] != letter && board[2][2] == letter) {
        }
        if (board[0][2] != letter && board[2][0] == letter) {
            return true;
        }
        return false;

    }
}
