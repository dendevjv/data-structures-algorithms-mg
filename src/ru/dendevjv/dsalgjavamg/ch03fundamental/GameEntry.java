package ru.dendevjv.dsalgjavamg.ch03fundamental;

public class GameEntry {
    private String name;
    private int score;
    
    public GameEntry(String n, int s) {
        name = n;
        score = s;
    }
    
    public String getName() { return name; }
    
    public int getScore() { return score; }
    
    @Override
    public String toString() {
        return "(" + name + ", " + score + ")";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        GameEntry other = (GameEntry) obj;
        return name.equals(other.name) && score == other.score;
    }
}
