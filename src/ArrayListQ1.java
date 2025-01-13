import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListQ1 {

	public static int countTarget(ArrayList<Integer> list, int target) {
		int result = 0;
		for (int el : list) {
			if (el == target)
				result += 1;
		}
		return result;
	}

	public static void printList(ArrayList<Integer> list) {
		System.out.print("List = [");
		for (int el : list) {
			System.out.print("  " + el);
		}
		System.out.println("  ] ");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		Collections.addAll(list, 4, 5, 4, 3, 2, 3, 1, 3, 4, 1);
		printList(list);
		System.out.print("Enter Target: ");
		int target = in.nextInt();
		int result = countTarget(list, target);
		System.out.print("" + target + " occurs " + result + " times");
	}
}
