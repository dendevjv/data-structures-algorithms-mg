package ru.dendevjv.dsalgjavamg.ch02.exercises;

public class C0226SquareRootProgression extends C0225GenericProgression <Double> {
    
    private static final double DEFAULT_START = 65536.0;

    public C0226SquareRootProgression() {
        super(DEFAULT_START);
    }

    public C0226SquareRootProgression(Double start) {
        super(start);
    }

    @Override
    protected void advance() {
        setCurrent(Math.sqrt(getCurrent()));
    }
    
    public static void main(String[] args) {
        C0226SquareRootProgression srp = new C0226SquareRootProgression();
        srp.printProgression(5);
    }

}
