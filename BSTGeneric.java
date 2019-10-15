package data_structures;

public class BSTGeneric<T extends Comparable<T>> {
	private static class Node<T> {
		private T data;
		private Node<T> leftChild;
		private Node<T> rightChild;
		
		private Node() {
			data = null;
			leftChild = null;
			rightChild = null;
		}

		private Node(T data) {
			this.data = data;
			leftChild = null;
			rightChild = null;
		}
	}
	
	private Node<T> root;
	private int counter;
	
	public BSTGeneric() {
		root = null;
	}
	
	public boolean isEmpty() {
		return (root == null);
	}
	
	public void insert(T data){
		/*Node<T> newNode = new Node<T>(data);
		if (root == null)
			root = newNode;
		if (root != null)*/
	}
}