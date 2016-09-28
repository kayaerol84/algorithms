package algorithms;

import java.util.ArrayList;

public class Tape {
	private ArrayList<Integer> files = new ArrayList<>();
	private int maxWeight = 100;
	private int totalWeight = 0;
	private int maxFileCount = 2;
	private int totalFile = 0;

	public Tape() {
	}

	public Tape(int maxWeight, int maxFileCount) {
		this.maxWeight = maxWeight;
		this.maxFileCount = maxFileCount;
	}
	 

	// Or is this supposed to be the Greedy algorithm??
	public boolean addItem(int weight) {
		if ((totalWeight + weight) <= maxWeight && totalFile < maxFileCount) {
			files.add(weight);
			totalWeight += weight;
			totalFile +=1;
			return true;
		} else {
			return false;
		}
	}

	public int getNumberOfFiles() {
		return files.size();
	}

	@Override
	public String toString() {
		return files.toString();
	}
}
