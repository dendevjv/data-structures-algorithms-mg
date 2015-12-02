package ru.dendevjv.dsalgjavamg.ch06stacks.examples;

/**
 *  Solving the Josephus problem using a circular queue.
 */
public class Cf0613Josephus {
    /**
     * Computes the winner of the Josephus problem using a circular queue.
     */
    public static <E> E computeWinner(CircularQueue<E> queue, int k) {
        if (queue.isEmpty()) {
            return null;
        }
        while (queue.size() > 1) {
            for (int i = 0; i < k - 1; i++) {   // skip past k - 1 elements
                queue.rotate();
            }
            E e = queue.dequeue();      // remove the front element from the queue
            System.out.println("      " + e + " is out");
        }
        return queue.dequeue();         // the winner
    }
    
    private static <E> CircularQueue<E> buildQueue(E[] a) {
        CircularQueue<E> queue = new LinkedCircularQueue<>();
        for (E e : a) {
            queue.enqueue(e);
        }
        return queue;
    }

    public static void main(String[] args) {
        String[] a1 = {"Alice", "Bob", "Cindy", "Doug", "Ed", "Fred"};
        String[] a2 = {"Gene", "Hope", "Irene", "Jack", "Kim", "Lance"};
        String[] a3 = {"Mike", "Roberto"};

        System.out.println("First winner is " + computeWinner(buildQueue(a1), 3));  // Alice
        System.out.println("Second winner is " + computeWinner(buildQueue(a2), 10));  // Hope
        System.out.println("Third winner is " + computeWinner(buildQueue(a3), 7));  // Roberto
    }

}
