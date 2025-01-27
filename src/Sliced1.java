import java.awt.Graphics;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Producer extends Thread {
    private NumberStore store;
    private int number;

    public Producer(NumberStore ns, int n) {
        store = ns;
        number = n;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                store.put(i);
                sleep((int) (Math.random() * 10));
            }
        } catch (Exception e) {
        }
    }
}

class Consumer extends Thread {
    private NumberStore store;
    private int number;

    public Consumer(NumberStore ns, int n) {
        store = ns;
        number = n;
    }

    public void run() {
        try {
            int value = 0;
            for (int i = 0; i < 10; i++) {
                value = store.get();
                System.out.println("Consumer #" + this.number
                        + " got: " + value);
                sleep((int) (Math.random() * 10));
            }
        } catch (Exception e) {
        }
    }
}

// -----------------------------------------------------------------------------------
class NumberStore {
    private int contents = 0;
    private boolean available = false;

    public synchronized int get() throws Exception {
        while (available == false) {
            wait();
        }
        available = false;
        notify();
        return contents;
    }

    public synchronized void put(int value) throws Exception {
        while (available == true) {
            wait();
        }

        contents = value;
        available = true;
        notify();
    }
}

// ---------------------------------------------------------------------------------------
public class Sliced1 {
    public static void main(String[] args) {
        NumberStore ns = new NumberStore();
        Producer p = new Producer(ns, 1);
        Consumer c = new Consumer(ns, 1);
        p.start();
        c.start();
    }
}
