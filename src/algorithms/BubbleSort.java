package algorithms;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] num = { 90, 80, 30, 7,5, 4,3,2, 1,0 };
		//int[] num = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		//bubbleSortDesc(num);
		bubbleSortAsc(num);
	}
	
	public static void binarySearch(int[] array, int searchItem) {
		
		int first = 0;
		int last = array.length - 1;
		int middle = (first + last) / 2;

		while (first <= last) {
			if (array[middle] < searchItem) {
				first = middle + 1;
			} else if (array[middle] == searchItem) {
				System.out.println(searchItem + " found at location " + (middle + 1) + ".");
				break;
			} else {
				last = middle - 1;
			}
			middle = (first + last) / 2;
		}
		if (first > last)
			System.out.println(searchItem + " is not found.\n");

	}

	public static void bubbleSortDesc(int[] num) {
		int j;
		boolean flag = true; // set flag to true to begin first pass
		int temp; // holding variable

		while (flag) {
			flag = false; // set flag to false awaiting a possible swap
			for (j = 0; j < num.length - 1; j++) {
				if (num[j] < num[j + 1]) // change to > for ascending sort
				{
					if (num[j] == 5) 
						System.out.println("buldum");
					temp = num[j]; // swap elements
					num[j] = num[j + 1];
					num[j + 1] = temp;
					flag = true; // shows a swap occurred
				}
			}
			System.out.println(Arrays.toString(num));
		}
	}

	private static void bubbleSortAsc(int[] intArray) {
        
        /*
         * In bubble sort, we basically traverse the array from first
         * to array_length - 1 position and compare the element with the next one.
         * Element is swapped with the next element if the next element is greater.
         *
         * Bubble sort steps are as follows.
         *
         * 1. Compare array[0] & array[1]
         * 2. If array[0] > array [1] swap it.
         * 3. Compare array[1] & array[2]
         * 4. If array[1] > array[2] swap it.
         * ...
         * 5. Compare array[n-1] & array[n]
         * 6. if [n-1] > array[n] then swap it.
         *
         * After this step we will have largest element at the last index.
         *
         * Repeat the same steps for array[1] to array[n-1]
         *  
         */
       
		int n = intArray.length;
		int temp = 0;

		System.out.println("Bubble Sort Asc \n");
		boolean flag = true;
		
		 
		for (int i = 0; i < n; i++) {
			flag = false; // set flag to false awaiting a possible swap
			for (int j = 1; j < (n - i); j++) {

				if (intArray[j - 1] > intArray[j]) {
					// swap the elements!
					temp = intArray[j - 1];
					intArray[j - 1] = intArray[j];
					intArray[j] = temp;
					flag = true;
				}

			}				
			System.out.println(Arrays.toString(intArray));
			if (!flag) break;
		}	
		
		
		

	}

}
