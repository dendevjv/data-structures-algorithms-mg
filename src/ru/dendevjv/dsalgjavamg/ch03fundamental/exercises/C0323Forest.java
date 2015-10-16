/*
    C-3.23 
    Suppose you are designing a multiplayer game that has n >= 1000 players, numbered 1 to n, interacting in an enchanted forest. The winner of this game is the
    first player who can meet all the other players at least once (ties are allowed).
    Assuming that there is a method meet(i, j), which is called each time a player i
    meets a player j (with i != j), describe a way to keep track of the pairs of meeting
    players and who is the winner.
 */
package ru.dendevjv.dsalgjavamg.ch03fundamental.exercises;

import java.util.Random;

public class C0323Forest {
    private static final int NUM_PLAYERS = 10;
    
    private static class Player {
        private static final boolean NOT_MET = false;
        private static final boolean MET = true;
        
        private int id;
        private boolean[] playersArray;
        private int metPlayersCount = 0;
        
        Player(int playerId) {
            id = playerId;
            playersArray = new boolean[NUM_PLAYERS];
        }
        
        boolean meet(int otherId) {
            int otherIdx = otherId - 1;
            if (id != otherId && playersArray[otherIdx] == NOT_MET) {
                playersArray[otherIdx] = MET;
                metPlayersCount++;
            }
            System.out.printf("player #%d meets player #%d%n", id, otherId);
            return metPlayersCount == (NUM_PLAYERS - 1);
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Player ");
            sb.append(id);
            sb.append(": [");
            sb.append(playersArray[0] ? "1" : "0");
            for (int i = 1; i < playersArray.length; i++) {
                sb.append(',');
                sb.append(playersArray[i] ? "1" : "0");
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Player[] players = new Player[NUM_PLAYERS];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(i + 1);
        }
        Random random = new Random();
        boolean playing = true;
        int i, j, id1, id2;
        while (playing) {
            do {
                i = random.nextInt(NUM_PLAYERS);
                j = random.nextInt(NUM_PLAYERS);
            } while (i == j);
            id1 = i + 1;
            id2 = j + 1;
            boolean winner1 = players[i].meet(id2);
            boolean winner2 = players[j].meet(id1);
            if (winner1 || winner2) {
                if (winner1 && winner2) {
                    System.out.printf("Tie between player #%d and player #%d%n", id1, id2);
                    System.out.println(players[i]);
                    System.out.println(players[j]);
                } else if (winner1) {
                    System.out.printf("Player #%d wins!%n", id1);
                    System.out.println(players[i]);
                } else if (winner2) {
                    System.out.printf("Player #%d wins!%n", id2);
                    System.out.println(players[j]);
                }
                playing = false;
            }
        }
    }

}
