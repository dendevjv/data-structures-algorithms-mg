package ru.dendevjv.dsalgjavamg.ch02.exercises;

import java.math.BigInteger;
import java.util.Scanner;

public class C0227FibonacciProgression extends C0225GenericProgression <BigInteger> {
    private BigInteger next;

    public C0227FibonacciProgression() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }
    
    public C0227FibonacciProgression(BigInteger first, BigInteger second) {
        super(first);
        next = second;
    }

    @Override
    protected void advance() {
        BigInteger nextValue = getCurrent().add(next);
        setCurrent(next);
        next = nextValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        C0227FibonacciProgression fb = new C0227FibonacciProgression();
        System.out.print("Enter length of progression: ");
        int n = sc.nextInt();
        sc.close();
        fb.printProgression(n);
        
        System.out.println("\nUsing Integer:");
        C0225FibonacciProgressionInt fbi = new C0225FibonacciProgressionInt();
        fbi.printProgression(n);
    }
    
}
