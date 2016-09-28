package algorithms;

public class SlicingProblem {

	public static void main(String[] args) {
		int A[] = {23171, 21011, 21123, 21366, 21013, 21367, 23171, 21011, 21123, 21366, 2101, 2136, 21366, 100};
		SlicingProblem slicing = new SlicingProblem();
		System.out.println("Max Profit: " + slicing.solutionMaxProfit(A));
		
		
		int B[] = {3,2,-6, 4, 0, -1, 6};
		System.out.println("Max Slice: " + slicing.maxSlice(B));
		
		int C[] = {-10};
		System.out.println("Max Slice: " + slicing.maxSlice(C));
		
		int D[] = {-3, -2, -6};
		System.out.println("Max Slice: " + slicing.maxSlice(D));
	}
	
	public int solutionMaxProfit(int[] A){
		/*
		 * def solution(A):
    max_profit = 0
    max_day = 0
    min_day = 200000
     
    for day in A:
        min_day = min(min_day, day)
        max_profit = max(max_profit, day-min_day)
     
    return max_profit
		 */
		
		int maxProfit = 0;
		//int maxDay = 0;
		int minDay = Integer.MAX_VALUE;
		
		for (int dayValue : A) {
			minDay = minDay < dayValue ? minDay : dayValue;
			maxProfit = maxProfit > dayValue - minDay ? maxProfit : dayValue - minDay;
			
		}
		
		System.out.println("Min Day :" + minDay);
		return maxProfit;
	}
	
	public int maxSlice(int[] A) {
		
		/*
		 * def solution(A):
    max_ending = max_slice = -1000000
    for a in A:
        max_ending = max(a, max_ending +a)
        max_slice = max(max_slice, max_ending)
         
    return max_slice
		 */
		int maxSlice = -10000000; 
		int maxEnding =	-10000000;
		
		for (int a : A) {
			maxEnding = Math.max(a, maxEnding + a);
			maxSlice = Math.max(maxSlice, maxEnding);
		}
		
		return maxSlice;
	}
}

