package ru.dendevjv.dsalgjavamg.ch02.exercises;

public class C0228 {
    private static class Packets {
        private static String[] defaultContent = {"A quick", "fox", "jumps", "over", "a lazy dog"};
        private static int index = -1;
        
        public static Packets next() {
            index++;
            if (index >= defaultContent.length) {
                index = 0;
            }
            return new Packets(defaultContent[index]);
        }
        
        private String content;
        
        private Packets(String c) {
            content = c;
        }
        
        @Override
        public String toString() {
            return "\"" + content + "\"";
        }
    }
    
    private static class Alice {
        private Packets packets;
        
        void generatePackets() {
            packets = Packets.next();
        }
        
        Packets getPackets() {
            generatePackets();
            System.out.println("Alice sent packets: " + packets);
            return packets;
        }
    }
    
    private static class Bob {
        private Packets packets;
        
        void readPackets() {
            System.out.println("Bob is reading packets: " + packets);
            packets = null;
        }
        
        void setPackets(Packets packets) {
            this.packets = packets;
            readPackets();
        }
    }
    
    private static class Internet {
        private Alice alice;
        private Bob bob;
        
        Internet(Alice a, Bob b) {
            alice = a;
            bob = b;
        }
        
        void checkAndDeliver() {
            Packets packets = alice.getPackets();
            if (packets != null) {
                bob.setPackets(packets);
            } else {
                System.out.println("Alice has no packets");
            }
        }
    }

    public static void main(String[] args) {
        Alice alice = new Alice();
        Bob bob = new Bob();
        Internet internet = new Internet(alice, bob);
        int numCycles = 8;
        for (int i = 0; i < numCycles; i++) {
            internet.checkAndDeliver();
        }
    }

}
