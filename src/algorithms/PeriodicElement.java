package algorithms;

import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;

class PeriodicElement {
	private int atomicNum;
	private float atomicWeight;
	private String abbreviation, name;

	PeriodicElement(int atomicNum, String abbreviation, String name, float atomicWeight) {
		this.atomicNum = atomicNum;
		this.abbreviation = abbreviation;
		this.name = name;
		this.atomicWeight = atomicWeight;
	}

	public int getNumber() {
		return atomicNum;
	}

	public String getAbb() {
		return abbreviation;
	}

	public String getName() {
		return name;
	}

	public float getWeight() {
		return atomicWeight;
	}

	public String toString() {
		return String.format("%3d %-3s %-20s %5.2f", atomicNum, abbreviation, name, atomicWeight);
	}
}

class PeriodicTable {
	private String fileName = "periodictable.dat";
	private String[][] table = new String[200][4];

	PeriodicTable(String fileName) {
		readTable(fileName);
	}

	public String[][] readTable(String fileName) {
		
		table = new String[200][40];
		table[0][0]="1";
		table[0][1]="H";
		table[0][2]="Hydrogen";
		table[0][3]="1.00794";

		table[1][0]="2";
		table[1][1]="He";
		table[1][2]="Helium";
		table[1][3]="4.002602";
		
		return table ;
		/*
		Scanner inFile = null;
		try {
			inFile = new Scanner(new File(fileName));
		} catch (FileNotFoundException nf) {
			System.out.println(fileName + " not found");
			System.exit(0);
		}

		table = new String[200][4];
		int i = 0;
		while (inFile.hasNext() && i < table.length) {
			int number = inFile.nextInt();
			String abbreviation = inFile.next();
			String name = inFile.next();
			float weight = inFile.nextFloat();
			String strNumber = String.valueOf(number);
			String strWeight = String.valueOf(weight);
			table[i][0] = strNumber;
			table[i][1] = abbreviation;
			table[i][2] = name;
			table[i][3] = strWeight;
			i++;
		}
		inFile.close();
		return table;*/
	}

	public int getNumberOfElements() {
		int counter = 0;
		for (int i = 0; i < table.length; i++) {
			if (table[i][0] != null) {
				counter++;
			}
		}
		return counter;
	}

	public String findElement(String number) {
		for (int i = 0; i < table.length; i++) {
			if (number == table[i][0]) {
				String strAtomicNum = table[i][0];
				String abbreviation = table[i][1];
				String name = table[i][2];
				String strAtomicWeight = table[i][3];

				int atomicNumber = Integer.parseInt(strAtomicNum);
				float atomicWeight = Float.parseFloat(strAtomicWeight);

				PeriodicElement element = new PeriodicElement(atomicNumber, abbreviation, name, atomicWeight);
				return element.toString();
			}
		}
		return null;
	}

	public String findAbbreviation(String abbreviation) {
		for (int i = 0; i < table.length; i++) {
			if (abbreviation == table[i][1]) {
				String strAtomicNum = table[i][0];
				String abbreviation1 = table[i][1];
				String name = table[i][2];
				String strAtomicWeight = table[i][3];

				int atomicNumber = Integer.parseInt(strAtomicNum);
				float atomicWeight = Float.parseFloat(strAtomicWeight);

				PeriodicElement element = new PeriodicElement(atomicNumber, abbreviation1, name, atomicWeight);
				return element.toString();
			}
		}
		return null;
	}

	public String printTable() {
		System.out.println("### $$$ $$$$$$$$$$$$$$$$$$$$ ###.##\n");
		for (int i = 0; i < table.length; i++) {
			String strAtomicNum = table[i][0];
			String abbreviation1 = table[i][1];
			String name = table[i][2];
			String strAtomicWeight = table[i][3];

			int atomicNumber = Integer.parseInt(strAtomicNum);
			float atomicWeight = Float.parseFloat(strAtomicWeight);

			PeriodicElement element = new PeriodicElement(atomicNumber, abbreviation1, name, atomicWeight);
			String elementInfo = element.toString();
			if (table[i][0] != null) {
				System.out.println(elementInfo);
			}
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println("Periodic Table by Ronald Lencevicius.\n");

		PeriodicTable table = new PeriodicTable("periodictable.dat");
		int numberElements = table.getNumberOfElements();
		System.out.println("Number of elements: " + numberElements + "\n");

		Scanner kb = new Scanner(System.in);
		Scanner kb1 = new Scanner(System.in);
		Scanner kb2 = new Scanner(System.in);
		int choice = 0;
		while (choice != 4) {
			System.out.println("1. Search atomic number");
			System.out.println("2. Search abbreviation");
			System.out.println("3. Print table");
			System.out.println("4. Exit\n");
			System.out.println("Enter a choice?");

			choice = kb.nextInt();

			if (choice == 1) {
				System.out.println("Enter atomic number: ");
				String elementNum = kb1.next();

				String element = table.findElement(elementNum);
				if (element != null) {
					System.out.println("### $$$ $$$$$$$$$$$$$$$$$$$$ ###.##\n" + element);
				} else {
					System.out.println("Not found");
				}
			} else if (choice == 2) {
				System.out.println("Enter abbreviation: ");
				String abbrev = kb2.next();

				String element = table.findAbbreviation(abbrev);
				if (element != null) {
					System.out.println("### $$$ $$$$$$$$$$$$$$$$$$$$ ###.##\n" + element);
				} else {
					System.out.println("Not found");
				}
			} else if (choice == 3) {
				table.printTable();
			} else if (choice == 4) {
				System.exit(0);
			}
		}
	}
}
