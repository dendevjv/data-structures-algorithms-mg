package ru.dendevjv.dsalgjavamg.ch02.projects.p0232;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class River {
    private static final boolean INFO = true;
    private static final Random random = new Random();
    
    private int size;
    private Animal[][] cells;
    private double bearToFishRate;
    private List<Animal> animals = new ArrayList<>();
    private int capacity;
    
    River(int size) {
        this.size = size;
        cells = new Animal[size][size];
        capacity = size * size;
    }
    
    River(int size, double bearToFishRate) { 
        this(size);
        this.bearToFishRate = bearToFishRate;
        int numAnimals = size * size / 4;
        for (int i = 0; i < numAnimals; i++) {
            addAnimal();
        }
    }
    
    public int getNumAnimals() {
        return animals.size();
    }
    
    public Animal get(int x, int y) {
        return cells[y][x];
    }
    
    void tick() {
        Animal a = findRandomAnimal();
        Point p = findRandomNearCell(a);
        move(a, p.x, p.y);
        display();
    }
    
    public void set(Animal a, int x, int y) {
        Point location = new Point(x, y);
        registerAnimal(location, a);
    }
    
    public void move(Animal a, int newX, int newY) {
        Animal target = cells[newY][newX];
        info(String.format("%s is going to move from (%d, %d) to (%d, %d)", 
                a, a.getX(), a.getY(), newX, newY));
        if (target == null) {
            makeMove(a, newX, newY);
        } else if (a.getClass() == target.getClass()) {
            if (a.isNotSameGender(target)) {
                Animal child = null;
                if (a.getClass() == Fish.class) {
                    child = new Fish();
                } else if (a.getClass() == Bear.class) {
                    child = new Bear();
                }
                addAnimal(child);
                info(String.format("%s is born at (%d, %d)", child, child.getX(), child.getY()));
            } else {
                if (a.isStrongerThan(target)) {
                    info(String.format("%s at (%d, %d) dies.", target, target.getX(), target.getY()));
                    target.die();
                    clearFromDeadAnimals();
                    makeMove(a, newX, newY);
                } else {
                    info(String.format("%s at (%d, %d) dies.", a, a.getX(), a.getY()));
                    a.die();
                    clearFromDeadAnimals();
                }
            }
        } else if (a.getClass() == Fish.class && target.getClass() == Bear.class) {
            /* Fish goes to Bear */
            info(String.format("Fish at (%d, %d) dies.", a.getX(), a.getY()));
            a.die();
            clearFromDeadAnimals();
        } else if (a.getClass() == Bear.class && target.getClass() == Fish.class) {
            /* Bear goes to Fish */
            info(String.format("Fish at (%d, %d) dies.", target.getX(), target.getY()));
            target.die();
            clearFromDeadAnimals();
            makeMove(a, newX, newY);
        }
    }
    
    public List<Animal> getAnimals() {
        return animals;
    }
    
    private void makeMove(Animal a, int newX, int newY) {
        info(String.format("%s moves from (%d, %d) to (%d, %d)", 
                a, a.getX(), a.getY(), newX, newY));
        cells[a.getY()][a.getX()] = null;
        cells[newY][newX] = a;
        a.setLocation(newX, newY);
    }
    
    public boolean hasAliveAnimalAt(int x, int y) {
        Animal a = cells[y][x];
        if (a == null) {
            return false;
        }
        return a.isAlive();
    }
    
    void display() {
        System.out.println(this.toString());
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder((size + 2) * (size + 1));
        String nl = System.lineSeparator();
        Animal cell;
        sb.append(' ');
        for (int col = 0; col < size; col++) {
            sb.append(col);
        }
        sb.append(nl);
        for (int row = 0; row < size; row++) {
            sb.append(row);
            for (int col = 0; col < size; col++) {
                cell = cells[row][col];
                if (cell == null) {
                    sb.append(' ');
                } else if (cell.getClass() == Bear.class) {
                    sb.append('B');
                } else if (cell.getClass() == Fish.class) {
                    sb.append('f');
                } else { throw new IllegalStateException("Cell must be empty or contain an animal"); }
            }
            sb.append(nl);
        }
        return sb.toString();
    }
    
    private void addAnimal() {
        Point location = findEmptyLocation();
        Animal animal = makeSemiRandomAnimal();
        registerAnimal(location, animal);
    }
    
    private Animal makeSemiRandomAnimal() {
        Animal a = null;
        if (random.nextDouble() < bearToFishRate) {
            a = new Bear();
        } else {
            a = new Fish();
        }
        return a;
    }
    
    private void addAnimal(Animal animal) {
        Point location = findEmptyLocation();
        registerAnimal(location, animal);
    }
    
    private Point findEmptyLocation() {
        int x = 0, y = 0;
        do {
            x = random.nextInt(size);
            y = random.nextInt(size);
        } while (cells[y][x] != null);
        return new Point(x, y);
    }
    
    private void registerAnimal(Point location, Animal animal) {
        if (getNumAnimals() < capacity) { 
            cells[location.y][location.x] = animal;
            animal.setLocation(location.x, location.y);
            animals.add(animal);
        } else {
            System.err.println("Cannot register animal - river is full.");
        }
    }
    
    private void clearFromDeadAnimals() {
        ListIterator<Animal> it = animals.listIterator();
        while (it.hasNext()) {
            Animal a = it.next();
            if (!a.isAlive()) {
                cells[a.getY()][a.getX()] = null;
                it.remove();
            }
        }
    }
    
    private Point findRandomNearCell(Animal a) {
        boolean found = false;
        int x = 0, y = 0;
        while (!found) {
            x = a.getX();
            y = a.getY();
            switch (random.nextInt(8)) {
            case 0: y--; break;
            case 1: y--; x++; break;
            case 2: x++; break;
            case 3: y++; x++; break;
            case 4: y++; break;
            case 5: y++; x--; break;
            case 6: x--; break;
            case 7: x--; y--; break;
            }
            if (x >= 0 && x < size && y >= 0 && y < size) {
                found = true;
            }
        }
        return new Point(x, y);
    }
    
    private Animal findRandomAnimal() {
        int i = random.nextInt(animals.size());
        return animals.get(i);
    }

    private void info(String msg) {
        if (INFO) {
            System.out.println(msg);
        }
    }
}
