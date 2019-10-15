package data_structures;

public class BST {
	private static class Node {
		private int data;
		private Node leftChild;
		private Node rightChild;
		
		private Node() {
			data = -1;
			leftChild = null;
			rightChild = null;
		}

		private Node(int data) {
			this.data = data;
			leftChild = null;
			rightChild = null;
		}
	}
	
	private Node root;
	private int counter;
	
	public BST() {
		root = null;
	}
	
	public boolean isEmpty() {
		return (root == null);
	}
	
	public void insert(int data) {
		
	}
}