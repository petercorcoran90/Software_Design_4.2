
import java.awt.Graphics;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Join1 {
       public static void main(String[] args) {
              Thread t = new Thread() {
                     public void run() {
                            System.out.println("EnterValue:");
                            try {
                                   System.in.read();
                            } catch (Exception ex) {
                            }
                            System.out.println("Thread Finished.");
                     }
              };
              System.out.println("Starting Thread");
              t.start();
              try {
                     Thread.sleep(2000);
              } catch (Exception e) {
              }
              try {
                     // 1t.join();
              } catch (Exception e1) {
              }
              System.out.println("Join");
              System.out.println("Main Finished.");
       }
}