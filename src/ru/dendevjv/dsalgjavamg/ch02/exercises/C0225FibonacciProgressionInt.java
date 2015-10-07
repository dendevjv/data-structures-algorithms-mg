package ru.dendevjv.dsalgjavamg.ch02.exercises;

public class C0225FibonacciProgressionInt extends C0225GenericProgression <Integer> {
    private Integer next;

    public C0225FibonacciProgressionInt() {
        super(Integer.valueOf(0));
        next = 1;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        C0225FibonacciProgressionInt fpr = new C0225FibonacciProgressionInt();
        fpr.printProgression(40);
    }

    @Override
    protected void advance() {
        Integer nextValue = getCurrent() + next;
        setCurrent(next);
        next = nextValue;
    }

}
