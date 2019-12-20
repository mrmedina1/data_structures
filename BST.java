package data_structures;

//Does not allow duplicate values
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
	private int numOfNodes;
	
	public BST() {
		root = null;
	}
	
	public boolean isEmpty() {
		return (root == null);
	}
	
	//Insert method calls insertRecurse method below.
	//Worst case time complexity of O(n).  General time complexity of O(h), where h is the height of the BST.
	public void insert(int data) {
		numOfNodes++;
		root = insertRecurse(root, data);
	}
	
	private Node insertRecurse(Node current, int data) {
		//base case
		if (current == null) {
			current = new Node(data);
			return current;
		}
		else if (data == current.data) {
			System.out.println("The value of " + data + " is already in the BST.");
			numOfNodes--;
		}
		
		//recursive case
		if (data < current.data)
			current.leftChild = insertRecurse(current.leftChild, data);
		else if (data > current.data)
			current.rightChild = insertRecurse(current.rightChild, data);
		
		return current;
	}
	
	//inorderTraversal method calls inorderTraversalRecurse method below.
	//Depth first traversal: (left, root, right)
	//O(n)
	public void inorderTraversal() {
		inorderTraversalRecurse(root);
	}
	
	private void inorderTraversalRecurse(Node current) {
		if (root == null)
			System.out.println("The BST is empty.");
		else if (current != null) {
			inorderTraversalRecurse(current.leftChild);
			System.out.println(current.data);
			inorderTraversalRecurse(current.rightChild);
		}
	}
	
	//preorderTraversal method calls preorderTraversalRecurse method below.
	//Depth first traversal: (root, left, right)
	//O(n)
	public void preorderTraversal() {
		preorderTraversalRecurse(root);
	}
	
	private void preorderTraversalRecurse(Node current) {
		if (root == null)
			System.out.println("The BST is empty.");
		if (current == null)
			return;
		System.out.println(current.data);
		preorderTraversalRecurse(current.leftChild);
		preorderTraversalRecurse(current.rightChild);
	}
	
	//postorderTraversal method calls postorderTraversalRecurse method below.
	//Depth first traversal: (left, right, root)
	//O(n)
	public void postorderTraversal() {
		postorderTraversalRecurse(root);
	}
	
	private void postorderTraversalRecurse(Node current) {
		if (root == null)
			System.out.println("The BST is empty.");
		else if (current != null) {
			postorderTraversalRecurse(current.leftChild);
			postorderTraversalRecurse(current.rightChild);
			System.out.println(current.data);
		}
	}
	
	//Search method calls searchRecurse method below.
	//Worst case time complexity of O(n).  General time complexity of O(h), where h is the height of the BST.
	public boolean search(int data) {
		return searchRecurse(root, data);
	}
	
	private boolean searchRecurse(Node current, int data) {
		//base case
		if (current == null) {
			return false;
		}
		else if (data == current.data) {
			return true;
		}
		
		//recursive case
		if (data < current.data)
			return searchRecurse(current.leftChild, data);
		else if (data > current.data)
			return searchRecurse(current.rightChild, data);
		
		return false;
	}
	
	//Delete method calls deleteRecurse method below.
	//Worst case time complexity of O(n).  General time complexity of O(h), where h is the height of the BST.
	public void delete(int data) {
		root = deleteRecurse(root, data);
	}
	
	private Node deleteRecurse(Node current, int data) {
		//base case
		if (current == null)
			return current;
		else if (data == current.data) {
			//1 child cases: Decrement number of nodes and set child to current node upon return.
			//Leaf node case: If there are no children, then node simply gets set to null on return.
			if (current.leftChild == null) {
				numOfNodes--;
				return current.rightChild;
			}
			else if (current.rightChild == null) {
				numOfNodes--;
				return current.leftChild;
			}
			//2 children case: copy largest of left subtree to current node, then delete current node.
			else {
				current.data = returnLargest(current.leftChild);
				current.leftChild = deleteRecurse(current.leftChild, current.data);
			}
		}

		//recursive case
		if (data < current.data)
			current.leftChild = deleteRecurse(current.leftChild, data);
		if (data > current.data)
			current.rightChild = deleteRecurse(current.rightChild, data);
		
		return current;
	}
	
	//returns largest of the left subtree to deleteRecurse method above
	private int returnLargest(Node current) {
		int largest = current.data;
		
		while (current != null) {
			largest = current.data;
			current = current.rightChild;
		}
		
		return largest;
	}
	
	//Height method calls heightRecurse method below and returns the height of the BST.
	//The height is the longest path from the root to a leaf node.  A one node BST has a height of 0.
	public int height() {
		return heightRecurse(root);
	}
	
	private int heightRecurse(Node current) {
		//if current is null: BST is empty, or reached end of path after leaf
		if (current == null)
			return -1;
		//else recur down the tree
		else
			return 1 + Math.max(heightRecurse(current.leftChild), heightRecurse(current.rightChild));
	}
	
	//numOfLeaves method calls numOfLeavesRecurse method below and returns the number of leaves in the BST.
	//A leaf if a node that has no children.
	public int numOfLeaves() {
		return numOfLeavesRecurse(root);
	}
	
	private int numOfLeavesRecurse(Node current) {
		//if current is null: BST is empty, or reached end of path after leaf
		if (current == null)
			return 0;
		//if both children are null then leaf node has been reached
		else if ((current.leftChild == null) && (current.rightChild == null))
			return 1;
		//else continue to recur down the tree
		else 
			return numOfLeavesRecurse(current.leftChild) + numOfLeavesRecurse(current.rightChild);
		
	}
	
	//returns total number of nodes in the BST.
	public int numOfNodes() {
		return numOfNodes;
	}
}