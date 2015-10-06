package ru.dendevjv.dsalgjavamg.ch02.exercises;

public class C0225GeometricProgression extends C0225GenericProgression <Integer> {
    private int base;
        public C0225GeometricProgression(int start, int base) {
        super(start);
        this.base = base;
    }

    @Override
    protected void advance() {
        setCurrent(getCurrent() * base);
    }

    public static void main(String[] args) {
        C0225GeometricProgression gp = new C0225GeometricProgression(1, 2);
        gp.printProgression(10);
    }
    
}
