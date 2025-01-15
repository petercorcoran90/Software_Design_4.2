import java.util.concurrent.*;

class ThreadTest extends Thread {

    public ThreadTest() {

    }

    public void run() {
        while (true) {
            System.out.print("Y");
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
            }
        }
    }
}

public class Exercise3 {

    public static void main(String[] args) {
        ThreadTest s1 = new ThreadTest();
        s1.start();
        while (true) {
            System.out.println("X");
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
            }
        }
    }
}
