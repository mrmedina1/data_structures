package data_structures;

public class LinkedList
{
	private static class Node
	{
		private int data;		//Instance variable
		private Node next;

		//constructor
		public Node()
		{
			data = -1;
			next = null;
		}
			
		//constructor to initialize data in node.  data will be null if not initialized
		public Node(int data)
		{
			this.data = data;
			next = null;
		}
	}

	Node head;				//Instance variables
	Node tail;
	int length = 0;
	
	public LinkedList()
	{
		head = null;
		tail = null;
	}
	
	public LinkedList(Node head, Node tail)
	{
		this.head = head;	//this.head is the instance variable above, head is the local variable (parameter of this method)
		this.tail = tail;
	}
	
	public boolean isEmpty()
	{
		return (head == null);
	}

	
	public void insertHead(int data)
	{
		Node newNode = new Node(data);
		if (head == null)
			head = tail = newNode;
		else
		{
			newNode.next = head;
			head = newNode;
		}
		length++;
	}
	
	//Each delete is O(1) constant time
	public void deleteHead()
	{
		if (head == null)
			System.out.println("The list is empty, cannot delete head.");
		else
		{
			head = head.next;
			length--;
		}
	}
	
	public void insertTail(int data)
	{
		Node newNode = new Node(data);
		if (head == null)
			head = tail = newNode;
		else
		{
			tail.next = newNode;
			tail = newNode;
		}
		length++;
	}

	//Each delete is O(n)
	public void deleteTail()
	{
		if (head == null)
			System.out.println("The list is empty, cannot delete tail.");
		else if (head.next == null)
		{
			head = tail = null;
			length--;
		}
		else
		{
			Node nextNode = head;
			Node previousNode = new Node();
			while (nextNode.next != null)
			{
				previousNode = nextNode;
				nextNode = nextNode.next;
			}
			tail = previousNode;
			tail.next = null;
			length--;
		}
	}

	public void destroy()
	{
		if  (head == null)
			System.out.println("There is no list to destroy.");
		else
		{
			while (head != null)
			{
				head = head.next;
				length--;
			}
			System.out.println("The list has been destroyed");
		}
	}

	public void print()
	{
		if (head == null)
			System.out.println("The list is empty.");
		Node currentNode = head;
		while (currentNode != null)
		{
			System.out.println(currentNode.data);
			currentNode = currentNode.next;
		}
	}
	
	public void printLength()
	{
		System.out.println("Current length of list is : " + length);
	}
	
	//Main method to test list
	public static void main(String[] args)
	{
		LinkedList ll = new LinkedList();
		
		ll.printLength();
		
		ll.print();
		
		ll.destroy();
		
		ll.insertHead(1);
		ll.insertHead(2);
		ll.insertHead(2);
		ll.insertHead(8);
		ll.insertHead(3);
		ll.insertHead(2);
		
		ll.printLength();
		
		ll.print();
		
		for (int i = 0; i <= 6; i++)
		{
			System.out.println("\n\n");
			ll.deleteTail();
			ll.print();
		}
		
		ll.print();
		
		ll.printLength();
	}
}