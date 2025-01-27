
class Join3 extends Thread {
	static int counter = 0;
	static int delay = 500;
	// static int delay=1000;

	public void run() {
		try {
			Thread.sleep(delay);
		} catch (Exception e) {
		}
		counter++;
	}

	public static void main(String[] args) throws Exception {
		Join3 t1 = new Join3();
		Join3 t2 = new Join3();
		t1.start();
		delay = 0;
		t2.start();
		t1.join();
		t2.join();
		System.out.println("Value=" + counter);
		System.out.println("Completed");
	}

}
