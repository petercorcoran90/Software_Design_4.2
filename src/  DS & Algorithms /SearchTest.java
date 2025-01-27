
import java.awt.Graphics;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;

public class SearchTest {

	public static boolean search(int[] list, int target) {
		for (int i = 0; i < list.length; i++) {
			if (list[i] == target) {
				return true;
			}
		}
		return false;

		// for (int el : list) {
		// 	if (el == target) {
		// 		return true;
		// 	}
		// }
		// return false;
	}

	public static void printList(int[] list) {
		System.out.print("\n[");
		for (int el : list) {
			System.out.print("  " + el);
		}
		System.out.println("] \n");
	}

	public static void main(String[] args) {
		int[] list = { 4, 1, 3, 8, 5, 2, 11, 21, 6 };
		Scanner sc = new Scanner(System.in);
		printList(list);
		System.out.print("Enter Target: ");
		int target = sc.nextInt();

		boolean res = search(list, target);
		System.out.println("\nTarget Found: " + res);
	}
}
