package algorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirst {

	private Node rootNode;

	public void bfs() {
		Queue queue = new LinkedList();
		queue.add(this.rootNode);
		printNode(this.rootNode);
		rootNode.visited = true;
		while (!queue.isEmpty()) {
			Node node = (Node) queue.remove();
			Node child = null;
			while ((child = getUnvisitedChildNode(node)) != null) {
				child.visited = true;
				printNode(child);
				queue.add(child);
			}

		}
		clearNodes();
	}

	private Node getUnvisitedChildNode(Node node) {
		// TODO Auto-generated method stub
		return null;
	}

	private void clearNodes() {
		// TODO Auto-generated method stub
		
	}

	public void dfs() {
		Stack stack = new Stack();
		stack.push(this.rootNode);
		rootNode.visited = true;
		printNode(rootNode);
		while (!stack.isEmpty()) {
			Node node = (Node) stack.peek();
			Node child = getUnvisitedChildNode(node);
			if (child != null) {
				child.visited = true;
				printNode(child);
				stack.push(child);
			} else {
				stack.pop();
			}
		}
		clearNodes();
	}

	private void printNode(Node child) {
		// TODO Auto-generated method stub
		
	}

}
