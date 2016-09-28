package algorithms;

public class Node {

	// private Node root;
	private Node left;
	private Node right;
	private int data;
	public boolean visited;

	public static void main(String[] args) {
		Node head = new Node(new Node(null, null, 5), new Node(null, null, 3), 4);
		head.insert(7);
		head.insert(8);
		head.insert(6);
		head.insert(2);
		head.insert(1);
		head.traverse(head);
	}

	public void traverse(Node root) { 
		// Each child of a tree is a root of its subtree.
		if (root.left != null) {
			traverse(root.left);
		}
		System.out.println(root.data);
		if (root.right != null) {
			traverse(root.right);
		}
	}

	public Node(Node left, Node right, int data) {
		super();
		this.left = left;
		this.right = right;
		this.data = data;
	}

	public void insert(int newValue) {
		if (newValue > data)
			if (left == null)
				left = new Node(null, null, newValue);
			else
				left.insert(newValue);
		else if (right == null)
			right = new Node(null, null, newValue);
		else
			right.insert(newValue);
	}

}
