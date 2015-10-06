package ru.dendevjv.dsalgjavamg.ch02.exercises;

public class C0221 {
    private static class A {
        int x;
        A() {
            x = 101;
        }
        
        @Override
        public String toString() {
            return "A:x=" + x;
        }
    }
    
    private static class B extends A {
        int x;
        
        B() {
            x = 2002;
        }
        
        @Override
        public String toString() {
            return super.toString() + ";B:x=" + x;
        }
    }
    
    private static class C extends B {
        int x;
        
        C() {
            x = 30003;
        }
        
        public void foo() {
            super.x = 17;
            ((A)this).x = 23;
        }
        
        @Override
        public String toString() {
            return super.toString() + ";C:x=" + x;
        }
    }

    public static void main(String[] args) {
        A a = new A();
        System.out.println(a);
        B b = new B();
        System.out.println(b);
        C c = new C();
        System.out.println(c);
        c.foo();
        System.out.println(c);
    }

}
