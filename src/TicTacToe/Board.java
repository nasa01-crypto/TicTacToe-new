package TicTacToe;

import java.util.Scanner;

public class Board {
    private char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

    private char[][] board2 = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    GamesChecks checks = new GamesChecks();
    private char player;
    private boolean gameDone = false;

    public void startGame() {

        Scanner input = new Scanner(System.in);
        player = 'X';
        while (!gameDone) {
            printBoard();
            System.out.println("Player 1:Enter row and column 0 - 2");
            if (player == 'X' && !gameOver('O', board)) {
                int row = input.nextInt();
                int col = input.nextInt();
                makeMove(row, col);

                System.out.println("Player 1: You won!");
            }
            printBoard();
            System.out.println("Player 2: Enter row and column 0 - 2");
            if (player == 'O' && !gameOver('X', board)) {
                int row = input.nextInt();
                int col = input.nextInt();
                makeMove2(row, col);
                printBoard();

            }
        }
        System.out.println("Player 2: You won!");


        printBoard();

        do {

            Scanner input2 = new Scanner(System.in);

            while (true) {
                printBoard2();
                player = 'X';
                System.out.println("Player 1:Enter row and column 0 - 2");
                if (player == 'X' && !gameOver('O', board2)) {
                    int row = input2.nextInt();
                    int col = input2.nextInt();
                    makeMove3(row, col);

                }


                printBoard2();
                System.out.println("Player 2: Enter row and column 0 - 2");
                if (player == 'O' && !gameOver('X', board2)) {
                    int row = input2.nextInt();
                    int col = input2.nextInt();
                    makeMove4(row, col);
                }
                System.out.println("You won!");
            }

        } while (true);

    }


    public void printBoard() {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
            }
            System.out.println();

        }
    }

    public void printBoard2() {
        System.out.println(board2[0][0] + "|" + board2[0][1] + "|" + board2[0][2]);
        System.out.println("-+-+-");
        System.out.println(board2[1][0] + "|" + board2[1][1] + "|" + board2[1][2]);
        System.out.println("-+-+-");
        System.out.println(board2[2][0] + "|" + board2[2][1] + "|" + board2[2][2]);

        for (int i = 0; i < board2.length; i++) {
            for (int j = 0; j < board2.length; j++) {
            }
            System.out.println();

        }
    }


    public void makeMove(int row, int col) {
        if (checks.isValid(row, col, board)) {
            board[row][col] = 'X';
            player = 'O';
        } else {
            System.out.println("N/A or valid space");
        }
    }

    public void makeMove2(int row, int col) {
        if (checks.isValid(row, col, board)) {
            board[row][col] = 'O';
            player = 'X';
        } else {
            System.out.println("N/A or valid space");
        }
    }

    public void makeMove3(int row, int col) {
        if (checks.isValid(row, col, board2)) {
            board2[row][col] = 'X';
            player = 'O';
        } else {
            System.out.println("N/A or valid space");
        }
    }

    public void makeMove4(int row, int col) {
        if (checks.isValid(row, col, board2)) {
            board2[row][col] = 'O';
            player = 'X';
        } else {
            System.out.println("N/A or valid space");
        }

    }
    public boolean victoryCheck(char letter, char[][] board) {
        if (checks.rowVictory(letter, board) || checks.colVictory(letter, board) || checks.diagonalVictory(letter, board)) {
            return true;
        }
        return false;
    }

    public boolean boardFull() {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[i][j] == '_' || board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean gameOver(char letter, char[][] board) {
        if (victoryCheck(letter, board)) {
            gameDone = true;
            return true;

        }

        if(boardFull()) {
            gameDone = true;
            System.out.println("No one won");
            return true;

        }
        return false;
    }
}