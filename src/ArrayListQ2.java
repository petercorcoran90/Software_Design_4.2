import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListQ2 {

	public static boolean containsTarget(ArrayList<Integer> list, int target) {
		boolean result = false;
		for (int el : list) {
			if (el == target)
				result = true;
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
		boolean result = containsTarget(list, target);
		System.out.print("" + target + " occurs in list = " + result);
	}
}
