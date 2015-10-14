package ru.dendevjv.dsalgjavamg.ch03fundamental.exercises.c0319;

import java.util.ListIterator;

import ru.dendevjv.dsalgjavamg.ch03fundamental.GameEntry;
import ru.dendevjv.dsalgjavamg.ch03fundamental.p4doublylinked.DoublyLinkedList;

public class C0319Scoreboard {
    private DoublyLinkedList<GameEntry> list;
    
    C0319Scoreboard() {
        list = new DoublyLinkedList<>();
    }
    
    int getSize() {
        return list.getSize();
    }
    
    void add(GameEntry e) {
        list.addLast(e);
    }
    
    GameEntry remove(int index) {
        ListIterator<GameEntry> it = list.listIterator();
        for (int i = 0; i < index; i++) {
            it.next();
        }
        GameEntry result = it.next();
        it.remove();
        return result;
    }
    
    GameEntry getTop() {
        return list.first();
    }
    
    @Override
    public String toString() {
        return list.toString();
    }

}
