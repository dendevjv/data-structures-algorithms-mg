package ru.dendevjv.dsalgjavamg.ch02.exercises;

public class C0225ArithmeticProgression extends C0225GenericProgression <Integer> {

    public C0225ArithmeticProgression(Integer start) {
        super(start);
    }
    
    @Override
    protected void advance() {
        setCurrent(getCurrent() + 1); 
    }

    public static void main(String[] args) {
        C0225ArithmeticProgression ap = new C0225ArithmeticProgression(1);
        ap.printProgression(10);
    }

}
