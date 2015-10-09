package ru.dendevjv.dsalgjavamg.ch03fundamental.p1tictactoe;

/** Simulation of a Tic-Tac-Toe game (does not do strategy). */
public class TicTacToe {
    public static final int SIZE = 3;
    public static final int X = 1, O = -1;
    public static final int EMPTY = 0;
    
    private int[][] board = new int[SIZE][SIZE];
    private int player;
    
    public TicTacToe() {
        clearBoard();
    }
    
    /**
     * Puts an X or O mark at position i, j.
     */
    public void putMark(int i, int j) throws IllegalArgumentException {
        if (i < 0 || i >= SIZE || j < 0 || j >= SIZE) {
            throw new IllegalArgumentException("Invalid board position");
        }
        if (board[i][j] != EMPTY) {
            throw new IllegalArgumentException("Board position occupied");
        }
        board[i][j] = player;
        changePlayer();
        
        System.out.println(this);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println();
    }
    
    /**
     * Checks whether the board configuration is a win for the given player.
     * @param mark player's mark
     */
    public boolean isWin(int mark) {
        for (int row = 0; row < SIZE; row++) {
            if (rowIsWinning(mark, row)) {
                return true;
            }
        }
        for (int col = 0; col < SIZE; col++) {
            if (colIsWinning(mark, col)) {
                return true;
            }
        }
        return diagonalIsWinning(mark) || diagonalReverersedIsWinning(mark);
    }
    
    /**
     * Returns the winning player's code, or 0 to indicate a tie (or unfinished game).
     */
    public int winner() {
        if (isWin(X)) {
            return X;
        } else if (isWin(O)) {
            return O;
        } else {
            return 0;
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                switch (board[i][j]) {
                case X:
                    sb.append("X"); break;
                case O:
                    sb.append("O"); break;
                case EMPTY:
                    sb.append(" "); break;
                }
                if (j < SIZE - 1) {
                    sb.append("|");
                }
            }
            if (i < SIZE - 1) {
                sb.append("\n");
                for (int k = 0; k < (SIZE * 2 - 1); k++) {
                    sb.append('-');
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }
    
    private boolean rowIsWinning(int mark, int row) {
        int sum = 0;
        for (int col = 0; col < SIZE; col++) {
            sum += board[row][col];
        }
        return (sum == mark * SIZE);
    }
    
    private boolean colIsWinning(int mark, int col) {
        int sum = 0;
        for (int row = 0; row < SIZE; row++) {
            sum += board[row][col];
        }
        return (sum == mark * SIZE);
    }
    
    private boolean diagonalIsWinning(int mark) {
        int sum = 0;
        for (int row = 0, col = 0; row < SIZE; row++, col++) {
            sum += board[row][col];
        }
        return (sum == mark * SIZE);
    }
    
    private boolean diagonalReverersedIsWinning(int mark) {
        int sum = 0;
        for (int row = 0, col = SIZE - 1; row < SIZE; row++, col--) {
            sum += board[row][col];
        }
        return (sum == mark * SIZE);
    }

    private int changePlayer() {
        if (player == X) {
            player = O;
        } else if (player == O) {
            player = X;
        }
        return player;
    }

    private void clearBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
        player = X;
    }
    
    /**
     * Test run of a simple game.
     */
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        
        /* X moves */           /* O moves */
        game.putMark(1, 1);     game.putMark(0, 2);  
        game.putMark(2, 2);     game.putMark(0, 0);  
        game.putMark(0, 1);     game.putMark(2, 1);  
        game.putMark(1, 2);     game.putMark(1, 0);  
        game.putMark(2, 0);     
        System.out.println(game);
        int winner = game.winner();
        String[] outcome = {"O wins", "Tie", "X wins"};
        System.out.println(outcome[1 + winner]);
    }
}
