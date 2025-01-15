import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Counter extends Thread implements ActionListener {
	private int counter;
	private JFrame f1 = new JFrame();
	private JLabel l = new JLabel();
	private Font fnt = new Font("TimesNewRoman", Font.BOLD, 16);
	Container content;
	private JButton b1 = new JButton("Suspend");
	private JButton b2 = new JButton("Resume");

	private boolean suspendFlag = false;

	Counter() {
		counter = 0;
		content = f1.getContentPane();
		l.setFont(fnt);
		l.setText("Counter:  " + 0);
		f1.setLayout(new FlowLayout());
		f1.setSize(192, 150);
		f1.setResizable(false);
		content.add(l);
		content.add(b1);
		content.add(b2);
		f1.setVisible(true);

		b1.addActionListener(this);
		b2.addActionListener(this);

	}

	public void mySuspend() {
		suspendFlag = true;
	}

	public synchronized void myResume() {
		suspendFlag = false;
		notify();
	}

	public void actionPerformed(ActionEvent e) {
		Object target = e.getSource();
		if (target == b1) {
			this.mySuspend();
		}
		if (target == b2) {
			this.myResume();
		}
	}

	public void run() {
		while (counter < 100) {
			counter++;
			l.setFont(fnt);
			l.setText("Counter:    " + counter);
			try {
				Thread.sleep(1000);
				synchronized (this) {
					while (suspendFlag) {
						wait();
					}
				}
			} catch (Exception e) {
			}
		}
	}
}

public class Q6Skel {
	public static void main(String[] args) {
		Counter c = new Counter();
		c.start();
	}
}
