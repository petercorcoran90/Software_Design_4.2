class Base {
	public String first;

	public Base(String f) {
		first = f;
	}

	public String getName() {
		return first;
	}
}

class Display extends Base implements Runnable {
	public String second;

	public Display(String f, String s) {
		super(f);
		second = s;
	}

	@Override
	public void run() {
		for (int i = 0; i < 4; i++) {
			System.out.println(super.getName() + " " + second + ": " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Q7Skel {
	public static void main(String[] args) {
		Display d1 = new Display("John", "Smith");
		Display d2 = new Display("Peter", "Doyle");

		Thread t1 = new Thread(d1);
		Thread t2 = new Thread(d2);

		t1.start();
		t2.start();
	}
}
