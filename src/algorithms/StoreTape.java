package algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class StoreTape {

	public static void main(String[] args) {

		int[] fileSizes = new int[]{70,20,10, 95};
		int tapeSize = 100;
		int result = getMinimumTapeCount(fileSizes, tapeSize);
		
		System.out.println("result: " + result);
		
		ArrayList<Tape> result1 = firstFit(fileSizes);
		
		System.out.println("result: " + result1);
		/*
		 * final Scanner input = new Scanner(System.in);
		 * 
		 * 
		 * System.out.print("Enter the number of files: "); double[] items = new
		 * double[input.nextInt()];
		 * 
		 * System.out.print("Enter the weight of the files: ");
		 * 
		 * for (int i = 0; i < items.length; i++) { items[i] =
		 * input.nextDouble(); }
		 * 
		 * ArrayList<Tape> containers = firstFit(items);
		 * 
		 * // Display results for (int i = 0; i < containers.size(); i++) {
		 * System.out.println("Container " + (i + 1) +
		 * " contains objects with weight " + containers.get(i)); }
		 * input.close();
		 */
	}

	public static int getMinimumTapeCount(final int[] fileSizes, final int tapeSize) {

		ArrayList<Tape> list = new ArrayList<>();

		for (int i = 0; i < fileSizes.length; i++) {
			boolean added = false;
			for (Tape tape : list) {
				if (tape.addItem(fileSizes[i])) {
					added = true;
					break;
				}
			}
			if (!added) {
				Tape tape = new Tape(tapeSize, 2);
				tape.addItem(fileSizes[i]);
				list.add(tape);
			}
		}
		return list.size();

	}

	// Greedy Algorithm??
	public static ArrayList<Tape> firstFit(int[] items) {
		ArrayList<Tape> list = new ArrayList<>();

		for (int i = 0; i < items.length; i++) {
			boolean added = false;
			for (Tape tape : list) {
				if (tape.addItem(items[i])) {
					added = true;
					break;
				}
			}
			if (!added) {
				Tape tape = new Tape(100, 2);
				tape.addItem(items[i]);
				list.add(tape);
			}
		}
		return list;
	}

}
