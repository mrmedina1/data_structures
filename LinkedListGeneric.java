package data_structures;

public class LinkedListGeneric<T>
{
	private static class Node<T>
	{
		private T data;		//Instance variable
		private Node<T> next;

		//constructor
		private Node()
		{
			data = null;
			next = null;
		}
			
		//constructor to initialize data in node.  data will be null if not initialized
		//this.data is the instance variable above, data is the local variable (parameter of this method)
		private Node(T data)
		{
			this.data = data;
			next = null;
		}
	}

	private Node<T> head;				//Instance variables
	private Node<T> tail;
	private int length = 0;
	
	public LinkedListGeneric()
	{
		head = null;
		tail = null;
	}
	
	public boolean isEmpty()
	{
		return (head == null);
	}

	public void insertHead(T data)
	{
		Node<T> newNode = new Node<T>(data);
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
		else if (head == tail)
		{
			head = tail = null;
			length--;
		}
		else
		{
			head = head.next;
			length--;
		}
	}
	
	public void printHead()
	{
		if (head == null)
			System.out.println("The list is empty, there is nothing to print.");
		else
			System.out.println(head.data);
	}
	
	public void insertTail(T data)
	{
		Node<T> newNode = new Node<T>(data);
		if (tail == null)
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
			Node<T> nextNode = head;
			Node<T> previousNode = new Node<T>();
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
	
	public void printTail()
	{
		if (tail == null)
			System.out.println("The list is empty, there is nothing to print.");
		else
			System.out.println(tail.data);
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

	public void printList()
	{
		if (head == null)
			System.out.println("The list is empty.");
		Node<T> currentNode = head;
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
}