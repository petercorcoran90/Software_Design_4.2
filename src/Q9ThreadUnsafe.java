
class Q9ThreadUnsafe extends Thread {
	static int index = 0, delay = 1000;
	static int[] array = new int[] { 3, 4, 5 };

	static int readNext() {
		int result = 0;
		if (index < 3) {
			try {
				Thread.sleep(delay);
			} catch (Exception e) {
			}
			result = array[index];
			index++;
			;
		} else {
			System.out.println("\nIndex Out of Bounds");
		}
		return result;
	}

	public void run() {
		System.out.println("Value = " + readNext());
	}

	public static void main(String[] args) {
		Q9ThreadUnsafe t1 = new Q9ThreadUnsafe();
		Q9ThreadUnsafe t2 = new Q9ThreadUnsafe();
		Q9ThreadUnsafe t3 = new Q9ThreadUnsafe();
		Q9ThreadUnsafe t4 = new Q9ThreadUnsafe();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
