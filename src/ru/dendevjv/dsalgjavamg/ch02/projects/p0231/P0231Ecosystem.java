/*
    P-2.31.
    Write a Java program to simulate an ecosystem containing two types of creatures,
    bears and fish. The ecosystem consists of a river, which is modeled as a relatively
    large array. Each cell of the array should contain an Animal object, which can
    be a Bear object, a Fish object, or null. In each time step, based on a random
    process, each animal either attempts to move into an adjacent array cell or stay
    where it is. If two animals of the same type are about to collide in the same
    cell, then they stay where they are, but they create a new instance of that type
    of animal, which is placed in a random empty (i.e., previously null) cell in the
    array. If a bear and a fish collide, however, then the fish dies (i.e., it disappears).
    Use actual object creation, via the new operator, to model the creation of new
    objects, and provide a visualization of the array after each time step.
 */
package ru.dendevjv.dsalgjavamg.ch02.projects.p0231;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;


public class P0231Ecosystem {
    private static final Random random = new Random();
    
    private abstract static class Animal {
        private boolean alive = true;
        private int x, y;
        
        boolean isAlive() { return alive; }
        void die() { alive = false; }
        void setLocation(int x, int y) { 
            this.x = x; this.y = y; 
        }
        int getX() { return x; }
        int getY() { return y; }
    }
    
    private static class Fish extends Animal {
        @Override
        public String toString() {
            return "Fish";
        }
    }
    
    private static class Bear extends Animal {
        @Override
        public String toString() {
            return "Bear";
        }
    }
    
    private static class River {
        private int size;
        private Animal[][] cells;
        private double bearToFishRate;
        private List<Animal> animals = new ArrayList<>();
        
        River(int size, double bearToFishRate) { 
            this.size = size;
            this.bearToFishRate = bearToFishRate;
            cells = new Animal[size][size];
            int numAnimals = size * size / 4;
            for (int i = 0; i < numAnimals; i++) {
                addAnimal();
            }
        }
        
        void tick() {
            Animal a = findRandomAnimal();
            makeRandomMove(a);
            clearFromDeadAnimals();
            display();
        }
        
        private void display() {
            System.out.println(this.toString());
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
        
        private void move(Animal a, int newX, int newY) {
            System.out.printf("%s moves from (%d, %d) to (%d, %d)%n", 
                    a, a.getX(), a.getY(), newX, newY);
            cells[a.getY()][a.getX()] = null;
            cells[newY][newX] = a;
            a.setLocation(newX, newY);
        }

        private void makeRandomMove(Animal a) {
            Point p = findRandomNearCell(a);
            Animal cell = cells[p.y][p.x];
            if (cell == null) {
                move(a, p.x, p.y);
            } else if (a.getClass() == cell.getClass()) {
                if (a.getClass() == Bear.class) {
                    addBear();
                } else if (a.getClass() == Fish.class) {
                    addFish();
                }
            } else if (a.getClass() == Bear.class && cell.getClass() == Fish.class) {
                System.out.printf("Fish at (%d, %d) dies.%n", cell.getX(), cell.getY());
                cell.die();
                clearFromDeadAnimals();
                move(a, p.x, p.y);
            } else if (a.getClass() == Fish.class && cell.getClass() == Bear.class) {
                System.out.printf("Fish at (%d, %d) dies.%n", a.getX(), a.getY());
                a.die();
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
            Animal animal = makeAnimal();
            registerAnimal(location, animal);
        }
        
        private void addBear() {
            Point location = findEmptyLocation();
            System.out.printf("Adding Bear at (%d, %d)%n", location.x, location.y);
            registerAnimal(location, new Bear());
        }
        
        private void addFish() {
            Point loc = findEmptyLocation();
            System.out.printf("Adding Fish at (%d, %d)%n", loc.x, loc.y); 
            registerAnimal(loc, new Fish());
        }
        
        void registerAnimal(Point location, Animal animal) {
            cells[location.y][location.x] = animal;
            animal.setLocation(location.x, location.y);
            animals.add(animal);
        }
        
        private Animal makeAnimal() {
            Animal a = null;
            if (random.nextDouble() < bearToFishRate) {
                a = new Bear();
            } else {
                a = new Fish();
            }
            return a;
        }
        
        private Point findEmptyLocation() {
            int x = 0, y = 0;
            do {
                x = random.nextInt(size);
                y = random.nextInt(size);
            } while (cells[y][x] != null);
            return new Point(x, y);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        River river = new River(8, 0.2);

        river.display();
        while (true) {
            String cmd = sc.nextLine();
            if ("exit".equals(cmd)) {
                break;
            }
            river.tick();
        }
        sc.close();
    }

}
