package ru.dendevjv.dsalgjavamg.ch02.projects.p0232;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ru.dendevjv.dsalgjavamg.ch02.projects.p0232.Animal.Gender;

public class RiverTest {
    private static final int SIZE_OF_TESTED_RIVER = 3;
    
    private River river;

    @Before
    public void setUp() throws Exception {
        river = new River(SIZE_OF_TESTED_RIVER);
    }
    
    @Test
    public void testFishGoesToFishSameGender() {
        Fish maleS = new Fish(Gender.MALE, 0.65);
        Fish maleW = new Fish(Gender.MALE, 0.3);
        int sx = 2, sy = 0; // source coords
        int dx = 1, dy = 1; // dest coords
        river.set(maleS, sx, sy);
        river.set(maleW, dx, dy);
        assertEquals(2, river.getNumAnimals());
        
        river.move(maleS, dx, dy);
        assertEquals(1, river.getNumAnimals());
        assertTrue(river.hasAliveAnimalAt(dx, dy));
        assertFalse(river.hasAliveAnimalAt(sx, sy));
        assertEquals(maleS, river.get(dx, dy));
        assertTrue(maleS.isAlive());
        assertFalse(maleW.isAlive());
        
        maleW = new Fish(Gender.MALE, 0.64);
        river.set(maleW, sx, sy);
        assertEquals(2, river.getNumAnimals());
        
        river.move(maleW, dx, dy);
        assertEquals(1, river.getNumAnimals());
        assertTrue(river.hasAliveAnimalAt(dx, dy));
        assertFalse(river.hasAliveAnimalAt(sx, sy));
        assertEquals(maleS, river.get(dx, dy));
        assertTrue(maleS.isAlive());
        assertFalse(maleW.isAlive());
    }
    
    @Test
    public void testFishGoesToFishDifferentGender() {
        Fish male = new Fish(Gender.MALE);
        Fish female = new Fish(Gender.FEMALE);
        int sx = 1, sy = 1; // source coords
        int dx = 0, dy = 0; // dest coords
        river.set(male, sx, sy);
        river.set(female, dx, dy);
        assertEquals(2, river.getNumAnimals());
        
        river.move(male, dx, dy);
        assertEquals(3, river.getNumAnimals());
        assertTrue(river.hasAliveAnimalAt(sx, sy));
        assertTrue(river.hasAliveAnimalAt(dx, dy));
        assertEquals(male, river.get(sx, sy));
        assertEquals(female, river.get(dx, dy));
        
        List<Animal> animals = river.getAnimals();
        Animal child = animals.get(animals.size() - 1);
        assertTrue(child.isAlive());
        assertEquals(Fish.class, child.getClass());
    }
    
    @Test
    public void testBearGoesToBearSameGender() {
        Bear maleS = new Bear(Gender.MALE, 0.7);
        Bear maleW = new Bear(Gender.MALE, 0.3);
        int sx = 2, sy = 0; // source coords
        int dx = 1, dy = 1; // dest coords
        river.set(maleS, sx, sy);
        river.set(maleW, dx, dy);
        assertEquals(2, river.getNumAnimals());
        
        river.move(maleS, dx, dy);
        assertEquals(1, river.getNumAnimals());
        assertTrue(river.hasAliveAnimalAt(dx, dy));
        assertFalse(river.hasAliveAnimalAt(sx, sy));
        assertEquals(maleS, river.get(dx, dy));
        assertTrue(maleS.isAlive());
        assertFalse(maleW.isAlive());
        
        maleW = new Bear(Gender.MALE, 0.6);
        river.set(maleW, sx, sy);
        assertEquals(2, river.getNumAnimals());
        
        river.move(maleW, dx, dy);
        assertEquals(1, river.getNumAnimals());
        assertTrue(river.hasAliveAnimalAt(dx, dy));
        assertFalse(river.hasAliveAnimalAt(sx, sy));
        assertEquals(maleS, river.get(dx, dy));
        assertTrue(maleS.isAlive());
        assertFalse(maleW.isAlive());
    }
    
    @Test
    public void testBearGoesToBearDifferentGender() {
        Bear male = new Bear(Gender.MALE);
        Bear female = new Bear(Gender.FEMALE);
        int sx = 0, sy = 2; // source coords
        int dx = 1, dy = 1; // dest coords
        river.set(male, sx, sy);
        river.set(female, dx, dy);
        assertEquals(2, river.getNumAnimals());
        
        river.move(male, dx, dy);
        assertEquals(3, river.getNumAnimals());
        assertTrue(river.hasAliveAnimalAt(sx, sy));
        assertTrue(river.hasAliveAnimalAt(dx, dy));
        assertEquals(male, river.get(sx, sy));
        assertEquals(female, river.get(dx, dy));
        
        List<Animal> animals = river.getAnimals();
        Animal child = animals.get(animals.size() - 1);
        assertTrue(child.isAlive());
        assertEquals(Bear.class, child.getClass());
    }
    
    @Test
    public void testFishGoesToBear() {
        Fish fish = new Fish();
        Bear bear = new Bear();
        int sx = 1, sy = 1; // source coords
        int dx = 0, dy = 0; // dest coords
        river.set(fish, sx, sy);
        river.set(bear, dx, dy);
        assertEquals(2, river.getNumAnimals());
        
        river.move(fish, dx, dy);
        assertEquals(1, river.getNumAnimals());
        assertEquals(Bear.class, river.get(dx, dy).getClass());
        assertTrue(river.hasAliveAnimalAt(dx, dy));
        assertFalse(river.hasAliveAnimalAt(sx, sy));
        assertTrue(bear.isAlive());
        assertFalse(fish.isAlive());
    }
    
    @Test
    public void testBearGoesToFish() {
        Fish fish = new Fish();
        Bear bear = new Bear();
        int sx = 1, sy = 1; // source coords
        int dx = 0, dy = 0; // dest coords
        river.set(bear, sx, sy);
        river.set(fish, dx, dy);
        assertEquals(2, river.getNumAnimals());
        
        river.move(bear, dx, dy);
        assertEquals(1, river.getNumAnimals());
        assertEquals(Bear.class, river.get(dx, dy).getClass());
        assertTrue(river.hasAliveAnimalAt(dx, dy));
        assertFalse(river.hasAliveAnimalAt(sx, sy));
        assertTrue(bear.isAlive());
        assertFalse(fish.isAlive());
    }

    @Test
    public void testMoveFish() {
        assertEquals(0, river.getNumAnimals());
        
        Animal a = new Fish();
        river.set(a, 1, 1);
        assertEquals(1, river.getNumAnimals());
        assertTrue(river.hasAliveAnimalAt(1, 1));
        
        river.move(a, 0, 0);
        assertFalse(river.hasAliveAnimalAt(1, 1));
        assertTrue(river.hasAliveAnimalAt(0, 0));
    }
    
    @Test
    public void testMoveBear() {
        assertEquals(0, river.getNumAnimals());
        
        Animal a = new Bear();
        river.set(a, 1, 1);
        assertEquals(1, river.getNumAnimals());
        assertTrue(river.hasAliveAnimalAt(1, 1));
        
        river.move(a, 2, 2);
        assertFalse(river.hasAliveAnimalAt(1, 1));
        assertTrue(river.hasAliveAnimalAt(2, 2));
    }

}
