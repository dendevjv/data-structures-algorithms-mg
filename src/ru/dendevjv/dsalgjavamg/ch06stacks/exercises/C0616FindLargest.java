/*
    C-6.16 
    Suppose Alice has picked three distinct integers and placed them into a stack S in
    random order. Write a short, straightline piece of pseudocode (with no loops or
    recursion) that uses only one comparison and only one variable x, yet that results
    in variable x storing the largest of Alice’s three integers with probability 2/3.
 */
package ru.dendevjv.dsalgjavamg.ch06stacks.exercises;

import java.util.Random;

import ru.dendevjv.dsalgjavamg.ch06stacks.examples.ArrayStack;
import ru.dendevjv.dsalgjavamg.ch06stacks.examples.Stack;

public class C0616FindLargest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Random rnd = new Random();
        Stack<Integer> stack = new ArrayStack<>(3);
        int max = 100;
        stack.push(rnd.nextInt(max));
        stack.push(rnd.nextInt(max));
        stack.push(rnd.nextInt(max));
        System.out.println(stack);
        
        int x;
        x = stack.pop();
        if (x < stack.top()) {
            x = stack.pop();
        }
        System.out.println("x = " + x);
    }

}
