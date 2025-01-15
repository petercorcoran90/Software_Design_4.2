import java.util.concurrent.*;

class Value {
    static int x = 0;
}

class Stepper {

    public Stepper() {
    }

    public void stepValue() {
        while (true) {
            Value.x++;
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
            }
        }
    }
}

class Printer extends Thread {

    public Printer() {
    }

    public void run() {
        while (true) {
            System.out.println("X= " + Value.x);
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
            }
        }
    }
}

public class Exercise4 {

    public static void main(String[] args) {
        Stepper s = new Stepper();
        Printer p = new Printer();
        p.start();
        s.stepValue();
    }
}
