package ru.dendevjv.dsalgjavamg.ch03fundamental;

/**
 * Class for storing high scores in an array in nondecreasing order.
 */
public class Scoreboard {
    private int numEntries = 0;
    private GameEntry[] board;
    
    public Scoreboard(int capacity) {
        board = new GameEntry[capacity];
    }
    
    public int getSize() {
        return numEntries;
    }
    
    /** Attempt to add a new score to the collection (if it is high enough. */
    public void add(GameEntry e) {
        int newScore = e.getScore();
        
        if (numEntries < board.length || newScore > board[numEntries - 1].getScore()) {
            if (numEntries < board.length) {
                numEntries++;
            }
            int j = numEntries - 1;
            while (j > 0 && board[j - 1].getScore() < newScore) {
                board[j] = board[j - 1];
                j--;
            }
            board[j] = e;
        }
    }
    
    public GameEntry remove(int index) {
        if (index < 0 || index >= numEntries) {
            throw new IndexOutOfBoundsException("Invalid index " + index);
        }
        GameEntry removed = board[index];
        for (int i = index; i < numEntries - 1; i++) {
            board[i] = board[i + 1];
        }
        board[numEntries - 1] = null;
        numEntries--;
        return removed;
    }
    
    public GameEntry getTop() {
        return board[0];
    }
    
    public GameEntry get(int index) {
        return board[index];
    }
}
