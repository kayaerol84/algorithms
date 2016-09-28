package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackSolution {

	public boolean isValidPair(char left, char right) {
	
		if (left == '(' && right == ')')
	        return true;
		else if (left == '[' && right == ']')
	        return true; 
		else if (left == '{' &&  right == '}')
	        return true;   
	    return false;
	}
	
	public static void main(String[] args) {
		/*
		 * stack = []
     
    for symbol in S:
        if symbol == '[' or symbol == '{' or symbol == '(':
            stack.append(symbol)
        else:
            if len(stack) == 0:
                return 0
            last = stack.pop()
            if not isValidPair(last, symbol):
                return 0
     
    if len(stack) != 0:
        return 0
             
    return 1
		 */	
		
		
		StackSolution sol =new StackSolution();
		
		int[] H = {8,8,5,7,9,8,7,4,8};
		System.out.println("Required Blocks: " + sol.manhattanSkyline(H));
		
		int[] H1 = {9,8,6,7,9,8,7,4,8};
		System.out.println("Required Blocks: " + sol.manhattanSkyline(H1));
		
		int[] H2 = {8,8,8,8,8,8,8,8,8};
		System.out.println("Required Blocks: " + sol.manhattanSkyline(H2));
		
		String testStr = "{[()()]}";
		System.out.println(sol.solutionStack(testStr.toCharArray()));
		
		String testStr2 = "{[]}";
		System.out.println(sol.solutionStack(testStr2.toCharArray()));
		
		String testStr3 = "{}[]()()[]{}";
		System.out.println(sol.solutionStack(testStr3.toCharArray()));
		
		String testBracket = "()()(";
		System.out.println(sol.bracketSolution(testBracket.toCharArray()));
		String testBracket1 = "((()))";
		System.out.println(sol.bracketSolution(testBracket1.toCharArray()));
		
		String testBracket2 = "()()()";
		System.out.println(sol.bracketSolution(testBracket2.toCharArray()));
	}
	
	public boolean solutionStack(char[] S){
		Stack<Character> stack = new Stack<Character>();
		for(char symbol: S){
			
			if (symbol == '[' || symbol == '{' || symbol == '(') {
				stack.push(symbol);
			} else {
				if (stack.size() == 0) {
					return false;
				}
				
				char last = stack.pop();
				if (!isValidPair(last, symbol)){
					return false;
				}
			}	
				
		}
		if (stack.size() != 0) 
			return false;
		
		return true;
	}
	
	public boolean bracketSolution(char[] S) {
		/*
		 * def solution(S):
    leftBrackets = 0
     
    for symbol in S:
        if symbol == '(':
            leftBrackets += 1
        else:
            if leftBrackets == 0:
                return 0
            leftBrackets -= 1 
     
    if leftBrackets != 0:
        return 0
     
    return 1

		 */
		int leftBrackets = 0;
		for (char symbol: S){
			if (symbol =='(') {
				leftBrackets +=1;				
			} else {
				if (leftBrackets == 0) {
					// it means that we have a right bracket but 0 left
					return false;
				}
				leftBrackets -=1; // if we have a right bracket, then 
			}
		}
		
		if (leftBrackets != 0) {
			return false;
		}
		
		return true;
	}
	
	public int manhattanSkyline(int[] H){
		/*
		 * def solution(H):
    block_cnt = 0
     
    stack = []
     
    for height in H:
        # remove all blocks that are bigger than my height
        while len(stack) != 0 and stack[-1] > height:
            stack.pop()
         
        if len(stack) != 0 and stack[-1] == height:
            # we already paid for this size
            pass
        else:
            # new block is required, push it's size to the stack
            block_cnt += 1
            stack.append(height)
             
    return block_cnt
		 */
		int blockCount = 0;
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int height : H) {
			
			while (stack.size() != 0 && stack.peek() > height) {
				stack.pop();				
			}
			
			if(stack.size() != 0 && stack.peek() == height) {
				continue;
			} else {
				blockCount +=1;
				stack.push(height);
			}
		}
		
		return blockCount;
	}
	
}
