import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class DisplayCountUp extends Thread {
	JLabel label;

	DisplayCountUp(JLabel l) {
		this.label = l;
	}

	public void run() {

		for (int i = 0; i <= 20; i++) {
			this.label.setText("Counter Up:  " + i);

			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
	}
}

class DisplayCountDown {
	JLabel label;

	DisplayCountDown(JLabel l) {
		this.label = l;
	}

	public void display() {
		for (int i = 20; i > 0; i--) {
			label.setText("Counter Dn:  " + i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
	}
}

class Counter {
	private int counter = 0;
	private JFrame f1 = new JFrame();
	public JLabel l1 = new JLabel();
	public JLabel l2 = new JLabel();
	private Font fnt = new Font("TimesNewRoman", Font.BOLD, 16);
	Container content;

	DisplayCountUp dcu;
	DisplayCountDown dcd;

	Counter() {
		counter = 0;
		content = f1.getContentPane();
		l1.setFont(fnt);
		l1.setText("Counter Up:  " + 0);
		l2.setFont(fnt);
		l2.setText("Counter Dn:  " + 20);
		f1.setLayout(new FlowLayout());
		f1.setSize(192, 150); // f1.setResizable(false);
		content.add(l1);
		content.add(l2);

		dcu = new DisplayCountUp(l1);
		dcd = new DisplayCountDown(l2);
		f1.setVisible(true);
		dcu.start();
		dcd.display();

	}

}

public class Q5Skel {
	public static void main(String[] args) {
		Counter c = new Counter();

	}
}
