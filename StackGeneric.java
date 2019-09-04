/*
Arrays cannot be declared as generic in Java, and although Java allows for casting an array to a 
generic type (i.e. T array[] = (T[]) new Object[10]), this way of casting does not enforce type safety.
A generic linked list is used for this reason.

Uses file: LinkedListGeneric.java
*/
package data_structures;

public class StackGeneric<T>
{
	private LinkedListGeneric<T> stack;
	private int size = 0;
	
	public StackGeneric(){
		stack = new LinkedListGeneric<T>();
	}

	public void push(T data){
		stack.insertHead(data);
		size++;
	}

	public void pop(){
		if ( isEmpty() ){
			System.out.println("Stack is empty. Cannot perform pop operation.");
			return;
		}
		System.out.print("Pop op: ");
		stack.printHead();
		stack.deleteHead();
		size--;
	}

	public void peek(){
		if ( isEmpty() ){
			System.out.println("Stack is empty. Cannot perform peek operation.");
			return;
		}
		System.out.print("Peek op: ");
		stack.printHead();
	}

	public boolean isEmpty(){
		return (size == 0);
	}
}